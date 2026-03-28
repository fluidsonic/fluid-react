package io.fluidsonic.react.router

import io.fluidsonic.react.*
import io.fluidsonic.react.router.external.*


@PublishedApi
internal external interface RMemoryRouterProps : RProps.WithChildren {

	var initialEntries: Array<out RPathTo>?
	var initialIndex: Int?
}


/** Renders an in-memory router for testing or non-browser environments. Wraps React Router's `MemoryRouter`. */
public inline fun RBuilder.MemoryRouter(
	initialEntries: Array<out RPathTo>? = undefined,
	initialIndex: Int? = undefined,
	content: RBuilder.() -> Unit,
) {
	ReactRouter_MemoryRouter::class {
		attrs.initialEntries = initialEntries
		attrs.initialIndex = initialIndex

		content()
	}
}
