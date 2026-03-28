@file:Suppress("NOTHING_TO_INLINE")

package io.fluidsonic.react


/** Base props interface for HTML/SVG tag elements, supporting [className] and children. */
public external interface RTagProps : RProps.WithChildren {

	public var className: String?
}


/** Reads a dynamic attribute by [key] from the tag props. */
public inline operator fun RTagProps.get(key: String): dynamic =
	asDynamic()[key]


/** Sets a dynamic attribute by [key] on the tag props. */
public inline operator fun RTagProps.set(key: String, value: dynamic) {
	asDynamic()[key] = value
}
