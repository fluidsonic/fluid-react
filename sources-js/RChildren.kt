package io.fluidsonic.react

import io.fluidsonic.react.external.*


public external interface RChildren : RElement


public inline fun RChildren?.forEach(block: (child: RElement?) -> Unit) {
	this?.toArray()?.forEach(block)
}


public inline fun RChildren?.forEachIndexed(block: (index: Int, child: RElement?) -> Unit) {
	this?.toArray()?.forEachIndexed(block)
}


public inline operator fun RChildren?.iterator(): Iterator<RElement?> =
	toArray().iterator()


public inline fun RChildren?.toArray(): Array<out RElement?> =
	External_Children.toArray(this)
