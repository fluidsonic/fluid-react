@file:Suppress("NOTHING_TO_INLINE")

package io.fluidsonic.react.router


public external interface RRoutePathFilter


public inline fun RRoutePathFilter(path: String): RRoutePathFilter =
	path.unsafeCast<RRoutePathFilter>()


public inline fun RRoutePathFilter(vararg paths: String): RRoutePathFilter =
	paths.unsafeCast<RRoutePathFilter>()


public inline fun RRoutePathFilter(paths: Array<out String>): RRoutePathFilter =
	paths.unsafeCast<RRoutePathFilter>()
