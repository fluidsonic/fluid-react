package io.fluidsonic.react


@kotlin.internal.InlineOnly
@PublishedApi
@Suppress("INVISIBLE_MEMBER", "INVISIBLE_REFERENCE")
internal inline fun <Result> Boolean.thenTake(block: () -> Result): Result? =
	if (this) block() else null
