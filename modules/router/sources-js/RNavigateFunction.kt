package io.fluidsonic.react.router


public class RNavigateFunction<in State> @PublishedApi internal constructor(
	private val delegate: (to: Any, options: RNavigateFunctionOptions<State>?) -> Unit,
) {

	public operator fun invoke(offset: Int) {
		delegate(offset, undefined)
	}


	public operator fun invoke(
		to: String,
		replace: Boolean? = undefined,
		state: State? = undefined,
	) {
		delegate(to, RNavigateFunctionOptions(replace = replace, state = state))
	}


	public operator fun invoke(
		to: RPathTo,
		replace: Boolean? = undefined,
		state: State? = undefined,
	) {
		delegate(to, RNavigateFunctionOptions(replace = replace, state = state))
	}
}
