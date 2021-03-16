package io.fluidsonic.react.router

import io.fluidsonic.react.*
import io.fluidsonic.react.router.external.*


@PublishedApi
internal external interface RBrowserRouterProps : RProps.WithChildren {

	var basename: String?
	var getUserConfirmation: ((message: String, callback: (ok: Boolean) -> Unit) -> Unit)?
	var forceRefresh: Boolean?
	var keyLength: Int?
}


@RDsl
public inline fun RBuilder.BrowserRouter(
	basename: String = "/",
	noinline getUserConfirmation: ((message: String, callback: (ok: Boolean) -> Unit) -> Unit)? = null,
	forceRefresh: Boolean = false,
	keyLength: Int = 6,
	content: RBuilder.() -> Unit,
) {
	ReactRouter_BrowserRouter::class {
		attrs.basename = basename
		getUserConfirmation?.let { attrs.getUserConfirmation = it }
		attrs.forceRefresh = forceRefresh
		attrs.keyLength = keyLength

		content()
	}
}
