package io.fluidsonic.react.router

import io.fluidsonic.react.*
import io.fluidsonic.react.router.external.*


@PublishedApi
internal external interface RMemoryRouterProps : RProps.WithChildren {

	var getUserConfirmation: ((message: String, callback: (ok: Boolean) -> Unit) -> Unit)?
	var initialEntries: Array<out RRouterLocationDescriptor<*>>?
	var initialIndex: Int?
	var keyLength: Int?
}


@RDsl
public inline fun RBuilder.MemoryRouter(
	noinline getUserConfirmation: ((message: String, callback: (ok: Boolean) -> Unit) -> Unit)? = null,
	initialEntries: Array<out RRouterLocationDescriptor<*>> = emptyArray(),
	initialIndex: Int? = null,
	keyLength: Int = 6,
	content: RBuilder.() -> Unit,
) {
	ReactRouter_MemoryRouter::class {
		attrs.getUserConfirmation = getUserConfirmation
		attrs.initialEntries = initialEntries
		attrs.initialIndex = initialIndex
		attrs.keyLength = keyLength

		content()
	}
}
