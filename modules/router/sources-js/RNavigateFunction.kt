package io.fluidsonic.react.router


/** A function for programmatic navigation with typed [State]. Wraps React Router's `NavigateFunction`. */
public class RNavigateFunction<in State> @PublishedApi internal constructor(
	private val delegate: (to: Any, options: RNavigateFunctionOptions<State>?) -> Unit,
) {

	/** Navigates by a relative history [offset] (e.g., `-1` to go back). */
	public operator fun invoke(offset: Int) {
		delegate(offset, undefined)
	}


	/** Navigates to the given string path. */
	public operator fun invoke(
		to: String,
		replace: Boolean? = undefined,
		state: State? = undefined,
	) {
		delegate(to, RNavigateFunctionOptions(replace = replace, state = state))
	}


	/** Navigates to the given [RPathTo] destination. */
	public operator fun invoke(
		to: RPathTo,
		replace: Boolean? = undefined,
		state: State? = undefined,
	) {
		delegate(to, RNavigateFunctionOptions(replace = replace, state = state))
	}
}
