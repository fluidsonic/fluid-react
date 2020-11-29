@file:Suppress("NOTHING_TO_INLINE")

package io.fluidsonic.react

import kotlin.reflect.*


public external interface RElementFactoryClass<Props : RProps>


public inline fun <Props : RProps> KClass<out RElementFactoryClass<Props>>.asFactory(): RElementFactory<Props> =
	js.unsafeCast<RElementFactory<Props>>()


public inline fun <Props : RProps> KClass<out RElementFactoryClass<in Props>>.asFactory(): RElementFactory<in Props> =
	js.unsafeCast<RElementFactory<Props>>()
