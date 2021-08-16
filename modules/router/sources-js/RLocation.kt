package io.fluidsonic.react.router


public external interface RLocation<out State> : RPartialLocation<State>, RPath {

	public override val key: String
	public override val state: State
}
