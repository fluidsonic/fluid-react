@file:Suppress("NOTHING_TO_INLINE")

package io.fluidsonic.react.router

import io.fluidsonic.react.*
import io.fluidsonic.react.router.external.*


/** Returns the current route's typed URL parameters. Wraps `useParams()`. */
@Suppress("unused")
public inline fun <Params : RRouteParams> RHooks.useRouteParams(): Params =
	reactRouter_useParams()


/** Returns how the current route was navigated to (pop, push, or replace). Wraps `useNavigationType()`. */
@Suppress("unused")
public inline fun RHooks.useRouterNavigationType(): RNavigationType =
	when (val type = reactRouter_useNavigationType()) {
		"POP" -> RNavigationType.pop
		"PUSH" -> RNavigationType.push
		"REPLACE" -> RNavigationType.replace
		else -> error("Unknown action: $type")
	}


/** Returns the current location with untyped state. Wraps `useLocation()`. */
public inline fun RHooks.useRouterLocation(): RLocation<*> =
	useRouterLocation<Any?>()


/** Returns the current location with typed [State]. Wraps `useLocation()`. */
@Suppress("unused")
public inline fun <State> RHooks.useRouterLocation(): RLocation<State> =
	reactRouter_useLocation()


/** Matches the current URL against a string [pattern]. Wraps `useMatch()`. */
public inline fun RHooks.useRouterMatch(pattern: String): RPathMatch<RRouteParams>? =
	useRouterMatch<RRouteParams>(pattern)


/** Matches the current URL against a string [pattern] with typed params. */
public inline fun <Params : RRouteParams> RHooks.useRouterMatch(pattern: String): RPathMatch<Params>? =
	useRouterMatch<Params>(RPathPattern(path = pattern))


/** Matches the current URL against a [pattern]. Wraps `useMatch()`. */
public inline fun RHooks.useRouterMatch(pattern: RPathPattern): RPathMatch<RRouteParams>? =
	useRouterMatch<RRouteParams>(pattern)


/** Matches the current URL against a [pattern] with typed params. */
@Suppress("unused")
public inline fun <Params : RRouteParams> RHooks.useRouterMatch(pattern: RPathPattern): RPathMatch<Params>? =
	reactRouter_useMatch(pattern)


/** Returns a function for programmatic navigation with untyped state. Wraps `useNavigate()`. */
@Suppress("unused")
public inline fun RHooks.useRouterNavigate(): RNavigateFunction<*> =
	useRouterNavigate<Any?>()


/** Returns a function for programmatic navigation with typed [State]. Wraps `useNavigate()`. */
@Suppress("unused")
public inline fun <State> RHooks.useRouterNavigate(): RNavigateFunction<State> =
	RNavigateFunction(delegate = reactRouter_useNavigate())
