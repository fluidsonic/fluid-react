@file:Suppress("NOTHING_TO_INLINE")

package io.fluidsonic.react.router

import io.fluidsonic.react.*
import io.fluidsonic.react.router.external.*


@PublishedApi
internal external interface RNavigateProps : RProps {

	var replace: Boolean?
	var state: Any?
	var to: RPathTo
}


/** Renders a navigation element that redirects to the given path. Wraps React Router's `Navigate`. */
public inline fun RBuilder.Navigate(
	to: String,
	replace: Boolean = false,
) {
	Navigate(to = RPathTo(to), replace = replace, state = undefined)
}


/** Renders a navigation element that redirects to the given [to] path with optional [state]. */
public inline fun RBuilder.Navigate(
	to: RPathTo,
	replace: Boolean = false,
	state: Any? = undefined,
) {
	ReactRouter_Redirect::class {
		attrs.replace = replace
		attrs.to = to
		attrs.state = state
	}
}
