@file:Suppress("NOTHING_TO_INLINE")

package io.fluidsonic.react


public external interface RTag<Props : RTagProps, RefElement : Any>


public inline fun <Props : RTagProps> RTag<Props, *>.asFactory(): RElementFactory<Props> =
	unsafeCast<RElementFactory<Props>>()


public inline val RTag<*, *>.name: String
	get() = unsafeCast<String>()
