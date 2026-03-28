package io.fluidsonic.react.router


/** A fully resolved router location with typed [State]. Wraps React Router's `Location`. */
public external interface RLocation<out State> : RPartialLocation<State>, RPath {

	public override val key: String
	public override val state: State
}
