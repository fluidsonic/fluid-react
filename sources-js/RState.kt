@file:Suppress("NOTHING_TO_INLINE")

package io.fluidsonic.react

import kotlin.reflect.*


/** Represents a React state value and its setter, as returned by `useState`. */
@Suppress("unused")
public external interface RState<Value>

/** Function type for setting a React state value. */
public typealias RSetState<Value> = (value: Value) -> Unit


/** Destructuring support: returns the current state value. */
public inline operator fun <Value> RState<Value>.component1(): Value =
	get()


/** Destructuring support: returns the state setter function. */
public inline operator fun <Value> RState<Value>.component2(): RSetState<Value> =
	asDynamic()[1].unsafeCast<RSetState<Value>>()


/** Returns the current state value. */
public inline fun <Value> RState<Value>.get(): Value =
	asDynamic()[0].unsafeCast<Value>()


/** Property delegate support: reads the current state value. */
public inline operator fun <Value> RState<Value>.getValue(thisRef: Any?, property: KProperty<*>): Value =
	component1()


/** Updates the state value and triggers a re-render. */
public inline fun <Value> RState<Value>.set(value: Value) {
	asDynamic()[0] = value
	component2()(value)
}


/** Property delegate support: updates the state value and triggers a re-render. */
public inline operator fun <Value> RState<Value>.setValue(thisRef: Any?, property: KProperty<*>, value: Value) {
	set(value)
}


/** Creates an [RState] from an explicit [value] and [setValue] function. */
public inline fun <Value> RState(value: Value, noinline setValue: RSetState<Value>): RState<Value> =
	arrayOf(value, setValue).unsafeCast<RState<Value>>()
