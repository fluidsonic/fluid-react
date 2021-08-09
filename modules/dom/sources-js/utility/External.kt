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


@JsName("createRoot")
@PublishedApi
internal external fun external_createRoot(
	container: Element,
): RRoot


@JsName("render")
@PublishedApi
internal external fun external_render(
	element: RElement?,
	container: Element,
	callback: (() -> Unit)? = definedExternally,
)

// FIXME
//@JsName("unstable_batchedUpdates")
//external fun unstable_batchedUpdates(block: () -> Unit)
