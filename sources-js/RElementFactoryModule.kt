@file:Suppress("NOTHING_TO_INLINE")

package io.fluidsonic.react


/** Represents a JavaScript module with a default export that is an [RElementFactory]. Used with `React.lazy()`. */
public external interface RElementFactoryModule<Props : RProps> {

	public val default: RElementFactory<Props>
}


/** Creates an [RElementFactoryModule] wrapping the given [default] factory. */
public inline fun <Props : RProps> RElementFactoryModule(default: RElementFactory<Props>): RElementFactoryModule<Props> =
	jsObject { it.default = default }
