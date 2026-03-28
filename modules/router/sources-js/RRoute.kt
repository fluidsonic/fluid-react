package io.fluidsonic.react.router

import io.fluidsonic.react.*
import io.fluidsonic.react.router.external.*


@PublishedApi
internal external interface RRouteProps : RProps {

	var caseSensitive: Boolean?
	var element: RElement?
	var path: String?
}


/** Defines a route that renders [content] when the [path] matches. Wraps React Router's `Route`. */
public inline fun RBuilder.Route(
	path: String,
	caseSensitive: Boolean? = undefined,
	crossinline content: RBuilder.() -> Unit,
) {
	ReactRouter_Route::class {
		attrs.caseSensitive = caseSensitive
		attrs.element = React.element(content) // TODO Consider rendering lazily using React.lazy().
		attrs.path = path
	}
}
