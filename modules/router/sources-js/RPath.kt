package io.fluidsonic.react.router


/** A fully resolved URL path with guaranteed [pathname], [search], and [hash] values. */
public external interface RPath : RPartialPath {

	public override val hash: String
	public override val pathname: String
	public override val search: String
}
