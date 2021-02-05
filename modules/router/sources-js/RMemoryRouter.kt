package io.fluidsonic.react.router

import io.fluidsonic.react.*
import io.fluidsonic.react.router.external.*


public external interface RMemoryRouterProps : RProps.WithChildren {

	public var getUserConfirmation: ((message: String, callback: (ok: Boolean) -> Unit) -> Unit)?
	public var initialEntries: Array<out RRouterLocationDescriptor<*>>?
	public var initialIndex: Int?
	public var keyLength: Int?
}


@RDsl
@Suppress("FunctionName")
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
