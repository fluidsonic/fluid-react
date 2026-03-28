@file:Suppress("NOTHING_TO_INLINE")

package io.fluidsonic.react

import io.fluidsonic.react.external.*
import kotlin.contracts.*


/** Marker interface for scopes where React hooks can be called. */
@RDsl
public external interface RHooks


/** Memoizes a [callback] function, only recreating it when [dependencies] change. Wraps React's `useCallback`. */
public inline fun <Callback : Function<*>?> RHooks.useCallback(
	vararg dependencies: Any?,
	callback: Callback,
): Callback =
	useMemo(dependencies = dependencies) { callback }.also {
		useDebugValue("useCallback()")
	}


/** Reads the current value from the given [context]. Wraps React's `useContext`. */
@Suppress("unused")
public inline fun <Value> RHooks.useContext(context: RContext<Value>): Value =
	external_useContext(context)


/** Displays a [value] in React DevTools for the current hook. No-op in production builds. Wraps React's `useDebugValue`. */
@Suppress("unused")
public inline fun RHooks.useDebugValue(value: Any?) {
	if (!isProduction())
		external_useDebugValue(value)
}


/** Runs the [effect] after every render. Wraps React's `useEffect`. */
public inline fun RHooks.useEffect(
	noinline effect: REffectBuilder.() -> Unit,
) {
	useRef(null)
	useDebugValue("useEffect() dependency")

	external_useEffect(buildEffect(effect))
}


/** Runs the [effect] when [dependencies] change. Wraps React's `useEffect`. */
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


/** Runs the [effect] synchronously after DOM mutations. Wraps React's `useLayoutEffect`. */
public inline fun RHooks.useLayoutEffect(
	noinline effect: REffectBuilder.() -> Unit,
) {
	useRef(null)
	useDebugValue("useLayoutEffect() dependencies")

	external_useLayoutEffect(buildEffect(effect))
}


/** Runs the [effect] synchronously after DOM mutations when [dependencies] change. Wraps React's `useLayoutEffect`. */
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


/** Memoizes the result of [createValue], recomputing only on first render. Wraps React's `useMemo`. */
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


/** Memoizes the result of [createValue], recomputing only when [dependencies] change. Wraps React's `useMemo`. */
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


/** Placeholder hook that maintains hook call order when a callback is conditionally unused. */
public inline fun RHooks.useNoCallback(): Nothing? {
	useCallback(noValue, callback = null)
	return null
}


/** Placeholder hook that maintains hook call order when an effect is conditionally unused. */
public inline fun RHooks.useNoEffect() {
	useEffect(noValue) {}
}


/** Placeholder hook that maintains hook call order when a layout effect is conditionally unused. */
public inline fun RHooks.useNoLayoutEffect() {
	useLayoutEffect(noValue) {}
}


/** Placeholder hook that maintains hook call order when a ref is conditionally unused. */
public inline fun RHooks.useNoRef(): Nothing? {
	useRef(null)
	return null
}


/** Creates a mutable ref initialized to `null`. Wraps React's `useRef`. */
@Suppress("unused")
public inline fun <Value : Any> RHooks.useRef(): RMutableRef<Value?> =
	useRef(null)


/** Creates a mutable ref initialized to [initialValue]. Wraps React's `useRef`. */
@Suppress("unused")
public inline fun <Value> RHooks.useRef(initialValue: Value): RMutableRef<Value> =
	external_useRef(initialValue)


/** Creates state initialized to [initialValue]. Wraps React's `useState`. */
@Suppress("unused")
public inline fun <Value> RHooks.useState(initialValue: Value): RState<Value> =
	external_useState(initialValue)


/** Creates nullable state initialized to `null`. Wraps React's `useState`. */
@Suppress("unused")
public inline fun <Value : Any> RHooks.useState(): RState<Value?> =
	external_useState(null)


/** Creates state initialized lazily by [initialValue]. Wraps React's `useState` with lazy initialization. */
@Suppress("unused")
public inline fun <Value> RHooks.useState(noinline initialValue: () -> Value): RState<Value> =
	external_useState(initialValue)


@Deprecated(message = "You can already use hooks in this scope.", level = DeprecationLevel.ERROR, replaceWith = ReplaceWith("nothing"))
@Suppress("unused")
public fun RHooks.useHooks(): Unit = Unit


@Deprecated(
	message = "Using hooks in this scope will likely lead to runtime errors.",
	level = DeprecationLevel.WARNING,
	replaceWith = ReplaceWith("nothing")
)
@OptIn(ExperimentalContracts::class)
@Suppress("CANNOT_CHECK_FOR_EXTERNAL_INTERFACE")
public inline fun RBuilder.useHooks() {
	contract {
		returns() implies (this@useHooks is RHooks)
	}
}
