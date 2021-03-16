@file:JsModule("react-router-dom")
@file:Suppress("ClassName")

package io.fluidsonic.react.router.external

import io.fluidsonic.react.*
import io.fluidsonic.react.router.*


@JsName("BrowserRouter")
@PublishedApi
internal external class ReactRouter_BrowserRouter : RElementFactoryClass<RBrowserRouterProps>


@JsName("HashRouter")
@PublishedApi
internal external class ReactRouter_HashRouter : RElementFactoryClass<RHashRouterProps>
