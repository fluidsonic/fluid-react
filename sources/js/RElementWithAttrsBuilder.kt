@file:Suppress("NOTHING_TO_INLINE")

package io.fluidsonic.react


@PublishedApi
internal external interface RElementWithAttrsBuilder<out Attrs : RProps> /* = Array<Attrs, *RElement?> */
	: RBuilder.WithAttrs<Attrs>


@PublishedApi
internal inline fun <Attrs : RProps> RElementWithAttrsBuilder(): RElementWithAttrsBuilder<Attrs> =
	arrayOf<Any>(jsObject()).unsafeCast<RElementWithAttrsBuilder<Attrs>>()


@PublishedApi
@Suppress("unused")
internal inline fun <Attrs : RProps> RElementWithAttrsBuilder<Attrs>.buildChildren(): Array<out RElement?> =
	data.slice(1).unsafeCast<Array<out RElement?>>()
