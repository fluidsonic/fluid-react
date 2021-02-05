package io.fluidsonic.react.router


public external interface RRouterHistory<State> {

	public val length: Int
	public val action: String // POP | PUSH | REPLACE
	public val location: RRouterLocation<State>

	public fun block(): () -> Unit
	public fun block(prompt: (location: RRouterLocation<State>, action: String) -> Boolean): () -> Unit
	public fun block(prompt: (location: RRouterLocation<State>, action: String) -> String): () -> Unit
	public fun block(prompt: Boolean): () -> Unit
	public fun block(prompt: String): () -> Unit
	public fun createHref(location: RRouterLocationDescriptor<State>): String
	public fun go(n: Int)
	public fun goBack()
	public fun goForward()
	public fun listen(listener: (location: RRouterLocation<State>, action: String) -> Unit): () -> Unit
	public fun push(location: RRouterLocationDescriptor<State>)
	public fun push(path: String, state: State? = definedExternally)
	public fun replace(location: RRouterLocationDescriptor<State>)
	public fun replace(path: String, state: State? = definedExternally)
}
