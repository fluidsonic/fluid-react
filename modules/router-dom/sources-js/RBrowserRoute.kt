package io.fluidsonic.react.router

import io.fluidsonic.react.*
import io.fluidsonic.react.router.external.*
import org.w3c.dom.*


@PublishedApi
internal external interface RBrowserRouterProps : RProps.WithChildren {

	var window: Window?
}


/** Renders a browser-based router using the HTML5 history API. Wraps React Router DOM's `BrowserRouter`. */
public inline fun RBuilder.BrowserRouter(
	window: Window? = undefined,
	content: RBuilder.() -> Unit,
) {
	ReactRouter_BrowserRouter::class {
		attrs.window = window

		content()
	}
}
