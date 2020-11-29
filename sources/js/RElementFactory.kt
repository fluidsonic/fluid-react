@file:Suppress("NOTHING_TO_INLINE")

package io.fluidsonic.react


public external interface RElementFactory<Props : RProps>


public inline fun (() -> RElement?).asFactory(): RElementFactory<RProps> =
	unsafeCast<RElementFactory<RProps>>()


public inline fun <Props : RProps> ((props: RProps) -> RElement?).asFactory(): RElementFactory<Props> =
	unsafeCast<RElementFactory<Props>>()
