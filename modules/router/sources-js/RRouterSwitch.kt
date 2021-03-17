package io.fluidsonic.react.router

import io.fluidsonic.react.*
import io.fluidsonic.react.router.external.*


@PublishedApi
internal external interface RRouterSwitchProps : RProps.WithChildren {

	var location: RRouterLocation<*>?
}


@RDsl
public inline fun RBuilder.RouteSwitch(
	location: RRouterLocation<*>? = null,
	content: RBuilder.() -> Unit,
) {
	ReactRouter_Switch::class {
		attrs.location = location

		content()
	}
}
