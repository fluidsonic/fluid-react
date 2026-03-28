@file:JsModule("react-dom/client")
@file:Suppress("FunctionName")

package io.fluidsonic.react.external

import io.fluidsonic.react.*
import org.w3c.dom.*


@JsName("createRoot")
@PublishedApi
internal external fun external_createRoot(
	container: Element,
): RRoot
