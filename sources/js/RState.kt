@file:Suppress("NOTHING_TO_INLINE")

package io.fluidsonic.react

import kotlin.reflect.*


@Suppress("unused")
public external interface RState<Value>

public typealias RSetState<Value> = (value: Value) -> Unit


public inline operator fun <Value> RState<Value>.component1(): Value =
	get()


public inline operator fun <Value> RState<Value>.component2(): RSetState<Value> =
	asDynamic()[1].unsafeCast<RSetState<Value>>()


public inline fun <Value> RState<Value>.get(): Value =
	asDynamic()[0].unsafeCast<Value>()


public inline operator fun <Value> RState<Value>.getValue(thisRef: Any?, property: KProperty<*>): Value =
	component1()


public inline fun <Value> RState<Value>.set(value: Value) {
	component2()(value)
}


public inline operator fun <Value> RState<Value>.setValue(thisRef: Any?, property: KProperty<*>, value: Value) {
	set(value)
}


public inline fun <Value> RState(value: Value, noinline setValue: RSetState<Value>): RState<Value> =
	arrayOf(value, setValue).unsafeCast<RState<Value>>()
