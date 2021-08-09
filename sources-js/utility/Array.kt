@file:Suppress("NOTHING_TO_INLINE")

package io.fluidsonic.react


@PublishedApi
internal inline fun Array<*>.join(separator: String): String =
	asDynamic().join(separator).unsafeCast<String>()


@PublishedApi
internal inline fun <Element> Array<in Element>.push(element: Element): Int =
	asDynamic().push(element).unsafeCast<Int>()


@PublishedApi
internal inline fun <Element> Array<out Element>.slice(start: Int = 0): Array<Element> =
	asDynamic().slice(start).unsafeCast<Array<Element>>()


@PublishedApi
internal inline fun <Element> Array<out Element>.slice(start: Int, end: Int): Array<Element> =
	asDynamic().slice(start, end).unsafeCast<Array<Element>>()
