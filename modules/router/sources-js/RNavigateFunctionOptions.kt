package io.fluidsonic.react.router

import io.fluidsonic.react.*


internal external interface RNavigateFunctionOptions<out State> {

	val replace: Boolean?
	val state: State?
}


internal fun RNavigateFunctionOptions(
	replace: Boolean? = undefined,
): RNavigateFunctionOptions<Nothing> =
	jsObject {
		it.replace = replace
	}


internal fun <State> RNavigateFunctionOptions(
	state: State? = undefined,
	replace: Boolean? = undefined,
): RNavigateFunctionOptions<State> =
	jsObject {
		it.state = state
		it.replace = replace
	}
