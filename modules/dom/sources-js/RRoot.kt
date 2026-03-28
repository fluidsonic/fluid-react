package io.fluidsonic.react


/** A React root for rendering into a DOM element. Wraps `ReactDOM.Root`. */
public external interface RRoot {

	public fun render(element: RElement?, callback: (() -> Unit)? = definedExternally)
	public fun unmount(callback: (() -> Unit) = definedExternally)
}


/** Renders the given [content] into this root. */
public inline fun RRoot.render(
	noinline callback: (() -> Unit)? = null,
	content: RBuilder.() -> Unit,
) {
	render(element = React.element(content), callback = callback)
}
