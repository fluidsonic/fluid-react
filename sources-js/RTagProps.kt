@file:Suppress("NOTHING_TO_INLINE")

package io.fluidsonic.react


public external interface RTagProps : RProps.WithChildren {

	public var className: String?
}


public inline operator fun RTagProps.get(key: String): dynamic =
	asDynamic()[key]


public inline operator fun RTagProps.set(key: String, value: dynamic) {
	asDynamic()[key] = value
}
