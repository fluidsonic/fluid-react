@file:Suppress("NOTHING_TO_INLINE")

package io.fluidsonic.react

import io.fluidsonic.react.external.*


/** Represents React child elements. Wraps React's `ReactNode` children. */
public external interface RChildren : RElement


/** Iterates over each child element, invoking [block] for each one. */
public inline fun RChildren?.forEach(block: (child: RElement?) -> Unit) {
	this?.toArray()?.forEach(block)
}


/** Iterates over each child element with its index, invoking [block] for each one. */
public inline fun RChildren?.forEachIndexed(block: (index: Int, child: RElement?) -> Unit) {
	this?.toArray()?.forEachIndexed(block)
}


/** Returns an iterator over the child elements, enabling `for` loops. */
public inline operator fun RChildren?.iterator(): Iterator<RElement?> =
	toArray().iterator()


/** Converts the children to a flat array. Wraps `React.Children.toArray()`. */
public inline fun RChildren?.toArray(): Array<out RElement?> =
	External_Children.toArray(this)
