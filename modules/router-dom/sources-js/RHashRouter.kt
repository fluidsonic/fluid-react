package io.fluidsonic.react.router

import io.fluidsonic.react.*
import io.fluidsonic.react.router.external.*


public external interface RHashRouterProps : RProps.WithChildren {

	public var basename: String?
	public var getUserConfirmation: ((message: String, callback: (ok: Boolean) -> Unit) -> Unit)?
	public var hashType: String? // slash | noslash | hashbang
}


@RDsl
public inline fun RBuilder.HashRouter(
	basename: String = "/",
	noinline getUserConfirmation: ((message: String, callback: (ok: Boolean) -> Unit) -> Unit)? = null,
	hashType: String = "slash", // slash | noslash | hashbang
	content: RBuilder.() -> Unit,
) {
	ReactRouter_HashRouter::class {
		attrs.basename = basename
		getUserConfirmation?.let { attrs.getUserConfirmation = it }
		attrs.hashType = hashType

		content()
	}
}
