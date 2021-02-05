package io.fluidsonic.react.router


public external interface RRouterLocation<out State> {

	public val hash: String
	public val key: String?
	public val pathname: String
	public val search: String
	public val state: State
}
