@file:Suppress("NOTHING_TO_INLINE")

package io.fluidsonic.react


@kotlin.internal.InlineOnly
@PublishedApi
@Suppress("INVISIBLE_MEMBER", "INVISIBLE_REFERENCE")
internal inline fun <T : Any> jsObject(): T =
	js("{}").unsafeCast<T>()


@kotlin.internal.InlineOnly
@PublishedApi
@Suppress("INVISIBLE_MEMBER", "INVISIBLE_REFERENCE")
internal inline fun <T : Any> jsObject(configure: (obj: dynamic) -> Unit): T {
	val obj = js("{}")
	configure(obj)

	return obj.unsafeCast<T>()
}
