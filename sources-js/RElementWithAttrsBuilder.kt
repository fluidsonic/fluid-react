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


