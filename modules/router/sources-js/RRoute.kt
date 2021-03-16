package io.fluidsonic.react.router

import io.fluidsonic.react.*
import io.fluidsonic.react.router.external.*


public external interface RRouteProps : RProps.WithChildren {

	public var exact: Boolean?
	public var location: RRouterLocation<*>?
	public var path: String?
	public var sensitive: Boolean?
	public var strict: Boolean?
}


@RDsl
public inline fun RBuilder.Route(
	path: String,
	exact: Boolean = true,
	location: RRouterLocation<*>? = null,
	sensitive: Boolean = true,
	strict: Boolean = true,
	content: RBuilder.() -> Unit,
) {
	ReactRouter_Route::class {
		attrs.exact = exact
		location?.let { attrs.location = it }
		attrs.path = path
		attrs.sensitive = sensitive
		attrs.strict = strict

		content()
	}
}
