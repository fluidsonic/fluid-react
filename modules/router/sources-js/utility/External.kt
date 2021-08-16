@file:JsModule("react-router")
@file:Suppress("ClassName", "FunctionName")

package io.fluidsonic.react.router.external

import io.fluidsonic.react.*
import io.fluidsonic.react.router.*


@JsName("matchPath")
@PublishedApi
internal external fun <Params : RRouteParams> reactRouter_matchPath(pattern: RPathPattern, pathname: String): RPathMatch<Params>?


@JsName("matchPath")
@PublishedApi
internal external fun reactRouter_resolvePath(to: RPathTo<*>, fromPathname: String): RPath


@JsName("useLocation")
@PublishedApi
internal external fun <State> reactRouter_useLocation(): RLocation<State>


@JsName("useMatch")
@PublishedApi
internal external fun <Params : RRouteParams> reactRouter_useMatch(pattern: RPathPattern): RPathMatch<Params>?


@JsName("useNavigate")
@PublishedApi
internal external fun <State> reactRouter_useNavigate(): (to: Any, options: RNavigateFunctionOptions<State>?) -> Unit


@JsName("useParams")
@PublishedApi
internal external fun <Params : RRouteParams> reactRouter_useParams(): Params


@JsName("MemoryRouter")
internal external class ReactRouter_MemoryRouter : RElementFactoryClass<RMemoryRouterProps>


@JsName("Navigate")
internal external class ReactRouter_Redirect : RElementFactoryClass<RNavigateProps>


@JsName("Route")
internal external class ReactRouter_Route : RElementFactoryClass<RRouteProps>


@JsName("Routes")
internal external class ReactRouter_Routes : RElementFactoryClass<RRoutesProps>
