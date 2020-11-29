@file:Suppress("NOTHING_TO_INLINE")

package io.fluidsonic.react.router

import io.fluidsonic.react.*


public external interface RRouteOptions {

	public val exact: Boolean
	public val path: RRoutePathFilter
	public val sensitive: Boolean
	public val strict: Boolean
}


@Suppress("FunctionName")
public inline fun RRouteOptions(
	path: RRoutePathFilter,
	exact: Boolean = false,
	sensitive: Boolean = false,
	strict: Boolean = false,
): RRouteOptions =
	jsObject {
		it.exact = exact
		it.path = path
		it.sensitive = sensitive
		it.strict = strict
	}


@Suppress("FunctionName")
public inline fun RRouteOptions(
	path: String,
	exact: Boolean = false,
	sensitive: Boolean = false,
	strict: Boolean = false,
): RRouteOptions =
	RRouteOptions(
		path = RRoutePathFilter(path),
		exact = exact,
		sensitive = sensitive,
		strict = strict,
	)
