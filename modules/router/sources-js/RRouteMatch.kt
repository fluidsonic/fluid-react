package io.fluidsonic.react.router


public external interface RRouteMatch<out Params : RRouteParams> {

	public val isExact: Boolean
	public val params: Params
	public val path: String
	public val url: String
}
