@file:Suppress("NOTHING_TO_INLINE")

package io.fluidsonic.react


/** Represents an HTML or SVG tag that produces elements with specific [Props] and [RefElement] types. */
public external interface RTag<Props : RTagProps, RefElement : Any>


/** Converts this tag to an [RElementFactory] for creating React elements. */
public inline fun <Props : RTagProps> RTag<Props, *>.asFactory(): RElementFactory<Props> =
	unsafeCast<RElementFactory<Props>>()


/** The HTML/SVG tag name (e.g., `"div"`, `"svg"`). */
public inline val RTag<*, *>.name: String
	get() = unsafeCast<String>()
