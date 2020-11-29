@file:Suppress("NOTHING_TO_INLINE")

package io.fluidsonic.react


@PublishedApi
internal external interface RElementBuilder /* = Array<RElement> */
	: RBuilder.WithHooks


@PublishedApi
internal inline fun RElementBuilder(): RElementBuilder =
	emptyArray<RElement?>().unsafeCast<RElementBuilder>()


@PublishedApi
@Suppress("unused")
internal inline fun RElementBuilder.buildChildren(): Array<out RElement?> =
	data.unsafeCast<Array<out RElement?>>()
