package io.fluidsonic.react

import io.fluidsonic.react.external.*
import org.w3c.dom.*


// FIXME
//	fun batchedUpdates(block: () -> Unit) {
//		react.unstable_batchedUpdates(block)
//	}


@RDsl
public inline fun React.render(
	container: Element,
	noinline callback: (() -> Unit)? = null,
	content: RBuilder.() -> Unit,
) {
	external_render(
		element = element(content),
		container = container,
		callback = callback
	)
}
