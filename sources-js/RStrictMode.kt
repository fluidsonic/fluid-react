package io.fluidsonic.react

import io.fluidsonic.react.external.*


/** Wraps content in React's `StrictMode` for development warnings. No-op in production builds. */
public inline fun RBuilder.StrictMode(content: RBuilder.() -> Unit) {
	if (isProduction())
		content()
	else
		External_StrictMode(content = content)
}
