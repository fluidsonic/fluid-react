@file:Suppress("NOTHING_TO_INLINE")

package io.fluidsonic.react


@PublishedApi
internal class RElementBuilder : RBuilder.WithHooks {

	val elements = arrayOf<RElement?>()


	override fun append(element: RElement?) {
		if (element != null)
			elements.push(element)
	}
}


// FIXME This is no longer an `external` interface due to changes in the Kotlin compiler introduced in 1.5.20.
//@PublishedApi
//internal external interface RElementBuilder /* = Array<RElement> */
//	: RBuilder.WithHooks
//
//
//@PublishedApi
//internal inline fun RElementBuilder(): RElementBuilder =
//	emptyArray<RElement?>().unsafeCast<RElementBuilder>()
//
//
//@PublishedApi
//@Suppress("unused")
//internal inline fun RElementBuilder.buildChildren(): Array<out RElement?> =
//	data.unsafeCast<Array<out RElement?>>()
