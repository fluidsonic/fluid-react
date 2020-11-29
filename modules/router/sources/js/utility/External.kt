@file:JsModule("react-router")
@file:Suppress("ClassName", "FunctionName")

package io.fluidsonic.react.router.external

import io.fluidsonic.react.*
import io.fluidsonic.react.router.*


@JsName("matchPath")
@PublishedApi
internal external fun <Params : RRouteParams> reactRouter_matchPath(
	path: String,
	options: RRouteOptions,
	parent: RRouteMatch<Params>? = definedExternally,
): RRouteMatch<Params>?


@JsName("useHistory")
@PublishedApi
internal external fun <State> reactRouter_useHistory(): RRouterHistory<State>


@JsName("useLocation")
@PublishedApi
internal external fun <State> reactRouter_useLocation(): RRouterLocation<State>


@JsName("useParams")
@PublishedApi
internal external fun <Params : RRouteParams> reactRouter_useParams(): Params


@JsName("useRouteMatch")
@PublishedApi
internal external fun <Params : RRouteParams> reactRouter_useRouteMatch(): RRouteMatch<Params>


@JsName("useRouteMatch")
@PublishedApi
internal external fun <Params : RRouteParams> reactRouter_useRouteMatch(options: RRouteOptions): RRouteMatch<Params>


@JsName("MemoryRouter")
internal external class ReactRouter_MemoryRouter : RElementFactoryClass<RMemoryRouterProps>


@JsName("Redirect")
internal external class ReactRouter_Redirect : RElementFactoryClass<RRedirectProps>


@JsName("Route")
internal external class ReactRouter_Route : RElementFactoryClass<RRouteProps>


@JsName("Switch")
internal external class ReactRouter_Switch : RElementFactoryClass<RRouterSwitchProps>
