package io.fluidsonic.react.router


/** The result of a path pattern match, containing extracted [params]. Wraps React Router's `PathMatch`. */
public external interface RPathMatch<out Params : RRouteParams> {

	public val params: Params
	public val path: String
	public val pathname: String
}
