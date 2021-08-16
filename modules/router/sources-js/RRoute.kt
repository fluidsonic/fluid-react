package io.fluidsonic.react.router

import io.fluidsonic.react.*
import io.fluidsonic.react.router.external.*


@PublishedApi
internal external interface RRouteProps : RProps {

	var caseSensitive: Boolean?
	var element: RElement?
	var path: String?
}


@RDsl
public inline fun RBuilder.Route(
	path: String,
	caseSensitive: Boolean? = undefined,
	crossinline content: RBuilder.() -> Unit,
) {
	ReactRouter_Route::class {
		attrs.caseSensitive = caseSensitive
		attrs.element = react.element(content) // FIXME Render lazy.
		attrs.path = path
	}
}
