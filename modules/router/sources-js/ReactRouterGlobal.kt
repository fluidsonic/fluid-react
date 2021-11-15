@file:Suppress("NOTHING_TO_INLINE")

package io.fluidsonic.react.router

import io.fluidsonic.react.*
import io.fluidsonic.react.router.external.*


public external interface ReactRouterGlobal


@RDsl
@Suppress("unused")
public inline val ReactGlobal.Router: ReactRouterGlobal
	get() = 0.unsafeCast<ReactRouterGlobal>()


@RDsl
public inline fun <Params : RRouteParams> ReactRouterGlobal.matchPath(
	pattern: RPathPattern,
	pathname: String,
): RPathMatch<Params>? =
	reactRouter_matchPath(pattern = pattern, pathname = pathname)


@RDsl
@Suppress("unused")
public inline fun <Params : RRouteParams> ReactRouterGlobal.matchPath(
	pattern: String,
	pathname: String,
): RPathMatch<Params>? =
	matchPath<Params>(pattern = RPathPattern(pattern), pathname = pathname)


@RDsl
public inline fun ReactRouterGlobal.matchPath(
	pattern: RPathPattern,
	pathname: String,
): RPathMatch<*>? =
	matchPath<RRouteParams>(pattern = pattern, pathname = pathname)


@RDsl
@Suppress("unused")
public inline fun ReactRouterGlobal.matchPath(
	pattern: String,
	pathname: String,
): RPathMatch<*>? =
	matchPath<RRouteParams>(pattern = pattern, pathname = pathname)


@RDsl
@Suppress("unused")
public inline fun ReactRouterGlobal.resolvePath(
	to: RPathTo,
	fromPathname: String = "/",
): RPath =
	reactRouter_resolvePath(to = to, fromPathname = fromPathname)


@RDsl
@Suppress("unused")
public inline fun ReactRouterGlobal.resolvePath(
	to: String,
	fromPathname: String = "/",
): RPath =
	resolvePath(to = RPathTo(to), fromPathname = fromPathname)
