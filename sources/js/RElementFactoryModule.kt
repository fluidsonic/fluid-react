@file:Suppress("NOTHING_TO_INLINE")

package io.fluidsonic.react


public external interface RElementFactoryModule<Props : RProps> {

	public val default: RElementFactory<Props>
}


public inline fun <Props : RProps> RElementFactoryModule(default: RElementFactory<Props>): RElementFactoryModule<Props> =
	jsObject { it.default = default }
