@file:Suppress("NOTHING_TO_INLINE")

package io.fluidsonic.react.router

import io.fluidsonic.react.*


public external interface RRouteOptions {

	public val exact: Boolean
	public val path: RRoutePathFilter
	public val sensitive: Boolean
	public val strict: Boolean
}


public inline fun RRouteOptions(
	path: RRoutePathFilter,
	exact: Boolean = true,
	sensitive: Boolean = true,
	strict: Boolean = true,
): RRouteOptions =
	jsObject {
		it.exact = exact
		it.path = path
		it.sensitive = sensitive
		it.strict = strict
	}


public inline fun RRouteOptions(
	path: String,
	exact: Boolean = true,
	sensitive: Boolean = true,
	strict: Boolean = true,
): RRouteOptions =
	RRouteOptions(
		path = RRoutePathFilter(path),
		exact = exact,
		sensitive = sensitive,
		strict = strict,
	)
