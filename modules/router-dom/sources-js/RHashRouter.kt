package io.fluidsonic.react.router

import io.fluidsonic.react.*
import io.fluidsonic.react.router.external.*
import org.w3c.dom.*


@PublishedApi
internal external interface RHashRouterProps : RProps.WithChildren {

	var window: Window?
}


/** Renders a hash-based router using the URL hash. Wraps React Router DOM's `HashRouter`. */
public inline fun RBuilder.HashRouter(
	window: Window? = undefined,
	content: RBuilder.() -> Unit,
) {
	ReactRouter_HashRouter::class {
		attrs.window = window

		content()
	}
}
