package io.fluidsonic.react.router

import io.fluidsonic.react.*
import io.fluidsonic.react.router.external.*
import io.fluidsonic.react.router.external.reactRouter_useRouteMatch as reactRouter_useRouteMatch1


@RDsl
public inline fun RHooks.useHistory(): RRouterHistory<*> =
	useHistory<Any?>()


@RDsl
@Suppress("unused")
public inline fun <State> RHooks.useHistory(): RRouterHistory<State> =
	reactRouter_useHistory()


@RDsl
public inline fun RHooks.useLocation(): RRouterLocation<*> =
	useLocation<Any?>()


@RDsl
@Suppress("unused")
public inline fun <State> RHooks.useLocation(): RRouterLocation<State> =
	reactRouter_useLocation()


@RDsl
@Suppress("unused")
public inline fun <Params : RRouteParams> RHooks.useParams(): Params =
	reactRouter_useParams()


@RDsl
@Suppress("unused")
public inline fun <Params : RRouteParams> RHooks.useRouteMatch(): RRouteMatch<Params> =
	reactRouter_useRouteMatch1()


@RDsl
public inline fun <Params : RRouteParams> RHooks.useRouteMatch(path: String): RRouteMatch<Params> =
	useRouteMatch(RRouteOptions(path = path))


@RDsl
public inline fun <Params : RRouteParams> RHooks.useRouteMatch(path: RRoutePathFilter): RRouteMatch<Params> =
	useRouteMatch(RRouteOptions(path = path))


@RDsl
@Suppress("unused")
public inline fun <Params : RRouteParams> RHooks.useRouteMatch(options: RRouteOptions): RRouteMatch<Params> =
	reactRouter_useRouteMatch1(options)
