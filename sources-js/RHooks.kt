@file:Suppress("NOTHING_TO_INLINE")

package io.fluidsonic.react

import io.fluidsonic.react.external.*
import kotlin.contracts.*


@RDsl
public external interface RHooks


@RDsl
public inline fun <Callback : Function<*>?> RHooks.useCallback(
	vararg dependencies: Any?,
	callback: Callback,
): Callback =
	useMemo(dependencies = dependencies) { callback }.also {
		useDebugValue("useCallback()")
	}


@RDsl
@Suppress("unused")
public inline fun <Value> RHooks.useContext(context: RContext<Value>): Value =
	external_useContext(context)


@RDsl
@Suppress("unused")
public inline fun RHooks.useDebugValue(value: Any?) {
	if (!isProduction())
		external_useDebugValue(value)
}


@RDsl
public inline fun RHooks.useEffect(
	noinline effect: REffectBuilder.() -> Unit,
) {
	useRef(null)
	useDebugValue("useEffect() dependency")

	external_useEffect(buildEffect(effect))
}


@RDsl
public inline fun RHooks.useEffect(
	vararg dependencies: Any?,
	noinline effect: REffectBuilder.() -> Unit,
) {
	val ref = useRef<Array<out Any?>>()
	useDebugValue("useEffect() dependency")

	val previousDependencies = ref.current
	if (!dependencies.contentEquals(previousDependencies))
		ref.current = dependencies

	external_useEffect(buildEffect(effect), arrayOf(ref.current))
}


@RDsl
public inline fun RHooks.useLayoutEffect(
	noinline effect: REffectBuilder.() -> Unit,
) {
	useRef(null)
	useDebugValue("useLayoutEffect() dependencies")

	external_useLayoutEffect(buildEffect(effect))
}


@RDsl
public inline fun RHooks.useLayoutEffect(
	vararg dependencies: Any?,
	noinline effect: REffectBuilder.() -> Unit,
) {
	val ref = useRef<Array<out Any?>>()
	useDebugValue("useLayoutEffect() dependencies")

	val previousDependencies = ref.current
	if (!dependencies.contentEquals(previousDependencies))
		ref.current = dependencies

	external_useLayoutEffect(buildEffect(effect), arrayOf(ref.current))
}


@RDsl
public inline fun <Value> RHooks.useMemo(
	createValue: () -> Value,
): Value {
	val ref = useRef<Any?>(noValue)
	useDebugValue("useMemo()")

	val current = ref.current

	return when {
		current === noValue -> createValue().also { ref.current = it }
		else -> current.unsafeCast<Value>()
	}
}


@RDsl
public inline fun <Value> RHooks.useMemo(
	vararg dependencies: Any?,
	createValue: () -> Value,
): Value {
	val ref = useRef<Array<Any?>?>(null)
	useDebugValue("useMemo()")

	val current = ref.current
	if (current != null) {
		val (previousValue, previousDependencies) = current
		if (dependencies.contentEquals(previousDependencies.unsafeCast<Array<out Any?>>()))
			return previousValue.unsafeCast<Value>()
	}

	val value = createValue()
	ref.current = arrayOf(value, dependencies)

	return value
}


@RDsl
public inline fun RHooks.useNoCallback(): Nothing? {
	useCallback(noValue, callback = null)
	return null
}


@RDsl
public inline fun RHooks.useNoEffect() {
	useEffect(noValue) {}
}


@RDsl
public inline fun RHooks.useNoLayoutEffect() {
	useLayoutEffect(noValue) {}
}


@RDsl
public inline fun RHooks.useNoRef(): Nothing? {
	useRef(null)
	return null
}


@RDsl
@Suppress("unused")
public inline fun <Value : Any> RHooks.useRef(): RMutableRef<Value?> =
	useRef(null)


@RDsl
@Suppress("unused")
public inline fun <Value> RHooks.useRef(initialValue: Value): RMutableRef<Value> =
	external_useRef(initialValue)


@RDsl
@Suppress("unused")
public inline fun <Value> RHooks.useState(initialValue: Value): RState<Value> =
	external_useState(initialValue)


@RDsl
@Suppress("unused")
public inline fun <Value : Any> RHooks.useState(): RState<Value?> =
	external_useState(null)


@RDsl
@Suppress("unused")
public inline fun <Value> RHooks.useState(noinline initialValue: () -> Value): RState<Value> =
	external_useState(initialValue)


@Deprecated(message = "You can already use hooks in this scope.", level = DeprecationLevel.ERROR, replaceWith = ReplaceWith("nothing"))
@RDsl
@Suppress("unused")
public fun RHooks.useHooks(): Unit = Unit


@Deprecated(
	message = "Using hooks in this scope will likely lead to runtime errors.",
	level = DeprecationLevel.WARNING,
	replaceWith = ReplaceWith("nothing")
)
@OptIn(ExperimentalContracts::class)
@RDsl
@Suppress("CANNOT_CHECK_FOR_EXTERNAL_INTERFACE")
public inline fun RBuilder.useHooks() {
	contract {
		returns() implies (this@useHooks is RHooks)
	}
}
