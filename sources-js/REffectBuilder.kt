@file:Suppress("NOTHING_TO_INLINE")

package io.fluidsonic.react


/** Builder scope for React effects, allowing registration of cleanup callbacks. */
public external interface REffectBuilder


@PublishedApi
internal inline fun buildEffect(noinline effect: REffectBuilder.() -> Unit): () -> (() -> Unit)? =
	effect@{
		val cleanups = arrayOf<() -> Unit>()
		val builder = cleanups.unsafeCast<REffectBuilder>()
		builder.effect()

		return@effect cleanups.isNotEmpty()
			.thenTake {
				{
					for (cleanup in cleanups)
						cleanup()
				}
			}
			?: undefined
	}


/** Registers a [callback] to be invoked when the effect is cleaned up. */
public inline fun REffectBuilder.cleanup(noinline callback: () -> Unit) {
	unsafeCast<Array<() -> Unit>>().push(callback)
}
