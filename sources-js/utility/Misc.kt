@file:Suppress("NOTHING_TO_INLINE")

package io.fluidsonic.react


@PublishedApi
internal inline fun isProduction(): Boolean =
	js("process.env.NODE_ENV === 'production'").unsafeCast<Boolean>()


@PublishedApi
internal val noValue: Any = Any()
