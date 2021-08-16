@file:Suppress("NOTHING_TO_INLINE")

package io.fluidsonic.react.router

import io.fluidsonic.react.*
import io.fluidsonic.react.router.external.*


@PublishedApi
internal external interface RNavigateProps : RProps {

	var replace: Boolean?
	var state: Any?
	var to: RPathTo<*>
}


@RDsl
public inline fun RBuilder.Navigate(
	to: String,
	replace: Boolean = false,
) {
	Navigate(to = RPathTo(to), replace = replace, state = undefined)
}


@RDsl
public inline fun RBuilder.Navigate(
	to: RPathTo<*>,
	replace: Boolean = false,
	state: Any? = undefined,
) {
	ReactRouter_Redirect::class {
		attrs.replace = replace
		attrs.to = to
		attrs.state = state
	}
}
