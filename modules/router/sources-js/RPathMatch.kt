package io.fluidsonic.react.router


public external interface RPathMatch<out Params : RRouteParams> {

	public val params: Params
	public val path: String
	public val pathname: String
}
