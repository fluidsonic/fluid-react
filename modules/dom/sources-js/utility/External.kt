@file:JsModule("react-dom")
@file:Suppress("FunctionName")

package io.fluidsonic.react.external

import io.fluidsonic.react.*
import org.w3c.dom.*


@JsName("createPortal")
@PublishedApi
internal external fun external_createPortal(
	children: RElement?,
	container: Element,
	key: String? = definedExternally,
): RElement
