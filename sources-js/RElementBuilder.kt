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


