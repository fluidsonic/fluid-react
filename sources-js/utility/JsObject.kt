@file:Suppress("NOTHING_TO_INLINE")

package io.fluidsonic.react


@PublishedApi
internal inline fun <T : Any> jsObject(): T =
	js("{}").unsafeCast<T>()


@PublishedApi
internal inline fun <T : Any> jsObject(configure: (obj: dynamic) -> Unit): T {
	val obj = js("{}")
	configure(obj)

	return obj.unsafeCast<T>()
}
