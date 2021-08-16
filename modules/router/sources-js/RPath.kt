package io.fluidsonic.react.router


public external interface RPath : RPartialPath {

	public override val hash: String
	public override val pathname: String
	public override val search: String
}
