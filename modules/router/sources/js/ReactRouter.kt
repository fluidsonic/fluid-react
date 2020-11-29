@file:Suppress("NOTHING_TO_INLINE")

package io.fluidsonic.react.router

import io.fluidsonic.react.*
import io.fluidsonic.react.router.external.*


public external interface ReactRouter


@RDsl
@Suppress("unused")
public inline val React.router: ReactRouter
	get() = 0.unsafeCast<ReactRouter>()


@RDsl
public inline fun <Params : RRouteParams> ReactRouter.matchPath(
	path: String,
	routePath: String,
	parent: RRouteMatch<Params>? = null,
): RRouteMatch<Params>? =
	matchPath<Params>(path = path, options = RRouteOptions(path = routePath), parent = parent)


@RDsl
@Suppress("unused")
public inline fun <Params : RRouteParams> ReactRouter.matchPath(
	path: String,
	options: RRouteOptions,
	parent: RRouteMatch<Params>? = null,
): RRouteMatch<Params>? =
	reactRouter_matchPath(path = path, options = options, parent = parent)


@RDsl
public inline fun ReactRouter.matchPath(
	path: String,
	routePath: String,
	parent: RRouteMatch<*>? = null,
): RRouteMatch<*>? =
	matchPath(path = path, options = RRouteOptions(path = routePath), parent = parent)


@RDsl
@Suppress("unused")
public inline fun ReactRouter.matchPath(
	path: String,
	options: RRouteOptions,
	parent: RRouteMatch<*>? = null,
): RRouteMatch<*>? =
	reactRouter_matchPath(path = path, options = options, parent = parent)
