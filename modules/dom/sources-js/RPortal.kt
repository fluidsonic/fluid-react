package io.fluidsonic.react

import io.fluidsonic.react.external.*
import org.w3c.dom.*


@RDsl
public inline fun RBuilder.Portal(container: Element, key: String? = null, content: RBuilder.() -> Unit) {
	external_createPortal(react.element(content), container = container, key = key)()
}
