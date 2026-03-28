@file:Suppress("NOTHING_TO_INLINE")

package io.fluidsonic.react.router

import io.fluidsonic.react.*
import io.fluidsonic.react.router.external.*


/** Namespace for React Router utility functions like [matchPath] and [resolvePath]. */
public external interface ReactRouterGlobal


/** Entry point for React Router utilities. */
@Suppress("unused")
public inline val ReactGlobal.Router: ReactRouterGlobal
	get() = 0.unsafeCast<ReactRouterGlobal>()


/** Matches a [pathname] against a [pattern], returning typed params if matched. Wraps `matchPath()`. */
public inline fun <Params : RRouteParams> ReactRouterGlobal.matchPath(
	pattern: RPathPattern,
	pathname: String,
): RPathMatch<Params>? =
	reactRouter_matchPath(pattern = pattern, pathname = pathname)


/** Matches a [pathname] against a string [pattern], returning typed params if matched. */
@Suppress("unused")
public inline fun <Params : RRouteParams> ReactRouterGlobal.matchPath(
	pattern: String,
	pathname: String,
): RPathMatch<Params>? =
	matchPath<Params>(pattern = RPathPattern(pattern), pathname = pathname)


/** Matches a [pathname] against a [pattern], returning untyped params if matched. */
public inline fun ReactRouterGlobal.matchPath(
	pattern: RPathPattern,
	pathname: String,
): RPathMatch<*>? =
	matchPath<RRouteParams>(pattern = pattern, pathname = pathname)


/** Matches a [pathname] against a string [pattern], returning untyped params if matched. */
@Suppress("unused")
public inline fun ReactRouterGlobal.matchPath(
	pattern: String,
	pathname: String,
): RPathMatch<*>? =
	matchPath<RRouteParams>(pattern = pattern, pathname = pathname)


/** Resolves a path [to] relative to [fromPathname]. Wraps `resolvePath()`. */
@Suppress("unused")
public inline fun ReactRouterGlobal.resolvePath(
	to: RPathTo,
	fromPathname: String = "/",
): RPath =
	reactRouter_resolvePath(to = to, fromPathname = fromPathname)


/** Resolves a string path [to] relative to [fromPathname]. */
@Suppress("unused")
public inline fun ReactRouterGlobal.resolvePath(
	to: String,
	fromPathname: String = "/",
): RPath =
	resolvePath(to = RPathTo(to), fromPathname = fromPathname)
