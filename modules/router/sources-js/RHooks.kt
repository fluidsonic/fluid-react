package io.fluidsonic.react.router

import io.fluidsonic.react.*
import io.fluidsonic.react.router.external.*


@RDsl
@Suppress("unused")
public inline fun <Params : RRouteParams> RHooks.useRouteParams(): Params =
	reactRouter_useParams()


@RDsl
@Suppress("unused")
public inline fun RHooks.useRouterAction(): RNavigationAction =
	when (val action = useContext(reactRouter_LocationContext_unsafe).action.unsafeCast<String>()) {
		"POP" -> RNavigationAction.pop
		"PUSH" -> RNavigationAction.push
		"REPLACE" -> RNavigationAction.replace
		else -> error("Unknown action: $action")
	}


@RDsl
public inline fun RHooks.useRouterLocation(): RLocation<*> =
	useRouterLocation<Any?>()


@RDsl
@Suppress("unused")
public inline fun <State> RHooks.useRouterLocation(): RLocation<State> =
	reactRouter_useLocation()


@RDsl
public inline fun RHooks.useRouterMatch(pattern: String): RPathMatch<RRouteParams>? =
	useRouterMatch<RRouteParams>(pattern)


@RDsl
public inline fun <Params : RRouteParams> RHooks.useRouterMatch(pattern: String): RPathMatch<Params>? =
	useRouterMatch<Params>(RPathPattern(path = pattern))


@RDsl
public inline fun RHooks.useRouterMatch(pattern: RPathPattern): RPathMatch<RRouteParams>? =
	useRouterMatch<RRouteParams>(pattern)


@RDsl
@Suppress("unused")
public inline fun <Params : RRouteParams> RHooks.useRouterMatch(pattern: RPathPattern): RPathMatch<Params>? =
	reactRouter_useMatch(pattern)


@RDsl
@Suppress("unused")
public inline fun RHooks.useRouterNavigate(): RNavigateFunction<*> =
	useRouterNavigate<Any?>()


@RDsl
@Suppress("unused")
public inline fun <State> RHooks.useRouterNavigate(): RNavigateFunction<State> =
	RNavigateFunction(delegate = reactRouter_useNavigate())
