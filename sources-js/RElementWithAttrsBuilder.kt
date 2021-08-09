@file:Suppress("NOTHING_TO_INLINE")

package io.fluidsonic.react


@PublishedApi
internal class RElementWithAttrsBuilder<out Attrs : RProps> : RBuilder.WithAttrs<Attrs> {

	val elements = arrayOf<RElement?>()

	override val attrs = jsObject<Attrs>()


	override fun append(element: RElement?) {
		if (element != null)
			elements.push(element)
	}
}


// FIXME This is no longer an `external` interface due to changes in the Kotlin compiler introduced in 1.5.20.
//@PublishedApi
//internal external interface RElementWithAttrsBuilder<out Attrs : RProps> /* = Array<Attrs, *RElement?> */
//	: RBuilder.WithAttrs<Attrs>
//
//
//@PublishedApi
//internal inline fun <Attrs : RProps> RElementWithAttrsBuilder(): RElementWithAttrsBuilder<Attrs> =
//	arrayOf<Any>(jsObject()).unsafeCast<RElementWithAttrsBuilder<Attrs>>()
//
//
//@PublishedApi
//@Suppress("unused")
//internal inline fun <Attrs : RProps> RElementWithAttrsBuilder<Attrs>.buildChildren(): Array<out RElement?> =
//	data.slice(1).unsafeCast<Array<out RElement?>>()
