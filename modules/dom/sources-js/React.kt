package io.fluidsonic.react

import io.fluidsonic.react.external.*
import org.w3c.dom.*


@RDsl
public inline fun React.createRoot(
	container: Element,
): RRoot =
	external_createRoot(container = container)


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
