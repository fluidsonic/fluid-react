package io.fluidsonic.react

import io.fluidsonic.react.external.*
import org.w3c.dom.*


/** Renders children into a different DOM [container] via a React portal. Wraps `ReactDOM.createPortal()`. */
public inline fun RBuilder.Portal(container: Element, key: String? = null, content: RBuilder.() -> Unit) {
	external_createPortal(React.element(content), container = container, key = key)()
}
