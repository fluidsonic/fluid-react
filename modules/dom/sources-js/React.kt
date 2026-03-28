@file:Suppress("NOTHING_TO_INLINE")

package io.fluidsonic.react

import io.fluidsonic.react.external.*
import org.w3c.dom.*


/** Creates a React root for the given DOM [container] element. Wraps `ReactDOM.createRoot()`. */
public inline fun ReactGlobal.createRoot(
	container: Element,
): RRoot =
	external_createRoot(container = container)


@Deprecated("ReactDOM.render() was removed in React 19. Use createRoot() instead.", level = DeprecationLevel.ERROR)
public inline fun ReactGlobal.render(
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
