@file:Suppress("NOTHING_TO_INLINE")

package io.fluidsonic.react

import io.fluidsonic.react.external.*
import org.w3c.dom.*


/** Creates a React root for the given DOM [container] element. Wraps `ReactDOM.createRoot()`. */
public inline fun ReactGlobal.createRoot(
	container: Element,
): RRoot =
	external_createRoot(container = container)
