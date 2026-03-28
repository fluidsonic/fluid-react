@file:Suppress("NOTHING_TO_INLINE")

package io.fluidsonic.react

import kotlin.reflect.*


/** Marker interface for external React component classes that can be used as element factories via their `KClass`. */
public external interface RElementFactoryClass<Props : RProps>


/** Converts the `KClass` of an external React component to an [RElementFactory]. */
public inline fun <Props : RProps> KClass<out RElementFactoryClass<Props>>.asFactory(): RElementFactory<Props> =
	js.unsafeCast<RElementFactory<Props>>()


/** Converts the `KClass` of an external React component to an [RElementFactory] with contravariant props. */
public inline fun <Props : RProps> KClass<out RElementFactoryClass<in Props>>.asFactory(): RElementFactory<in Props> =
	js.unsafeCast<RElementFactory<Props>>()
