package io.fluidsonic.react


@kotlin.internal.InlineOnly
@PublishedApi
@Suppress("INVISIBLE_MEMBER", "INVISIBLE_REFERENCE")
internal inline fun Array<*>.join(separator: String): String =
	asDynamic().join(separator).unsafeCast<String>()


@kotlin.internal.InlineOnly
@PublishedApi
@Suppress("INVISIBLE_MEMBER", "INVISIBLE_REFERENCE")
internal inline fun <Element> Array<in Element>.push(element: Element): Int =
	asDynamic().push(element).unsafeCast<Int>()


@kotlin.internal.InlineOnly
@PublishedApi
@Suppress("INVISIBLE_MEMBER", "INVISIBLE_REFERENCE")
internal inline fun <Element> Array<out Element>.slice(start: Int = 0): Array<Element> =
	asDynamic().slice(start).unsafeCast<Array<Element>>()


@kotlin.internal.InlineOnly
@PublishedApi
@Suppress("INVISIBLE_MEMBER", "INVISIBLE_REFERENCE")
internal inline fun <Element> Array<out Element>.slice(start: Int, end: Int): Array<Element> =
	asDynamic().slice(start, end).unsafeCast<Array<Element>>()
