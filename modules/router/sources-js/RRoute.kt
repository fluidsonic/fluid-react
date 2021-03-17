package io.fluidsonic.react.router

import io.fluidsonic.react.*
import io.fluidsonic.react.router.external.*


@PublishedApi
internal external interface RRouteProps : RProps.WithChildren {

	var exact: Boolean?
	var location: RRouterLocation<*>?
	var path: String?
	var render: (() -> RElement?)?
	var sensitive: Boolean?
	var strict: Boolean?
}


@RDsl
public inline fun RBuilder.Route(
	path: String,
	exact: Boolean = true,
	location: RRouterLocation<*>? = null,
	sensitive: Boolean = true,
	strict: Boolean = true,
	crossinline content: RBuilder.() -> Unit,
) {
	ReactRouter_Route::class {
		attrs.exact = exact
		location?.let { attrs.location = it }
		attrs.path = path
		attrs.render = { react.element(content) }
		attrs.sensitive = sensitive
		attrs.strict = strict
	}
}
