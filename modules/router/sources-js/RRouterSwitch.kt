package io.fluidsonic.react.router

import io.fluidsonic.react.*
import io.fluidsonic.react.router.external.*


public external interface RRouterSwitchProps : RProps.WithChildren {

	public var location: RRouterLocation<*>?
}


@RDsl
@Suppress("FunctionName")
public inline fun RBuilder.RouteSwitch(
	location: RRouterLocation<*>? = null,
	content: RBuilder.() -> Unit,
) {
	ReactRouter_Switch::class {
		attrs.location = location

		content()
	}
}
