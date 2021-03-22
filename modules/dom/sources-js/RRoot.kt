package io.fluidsonic.react


public external interface RRoot {

	public fun render(element: RElement?, callback: (() -> Unit)? = definedExternally)
	public fun unmount(callback: (() -> Unit) = definedExternally)
}


@RDsl
public inline fun RRoot.render(
	noinline callback: (() -> Unit)? = null,
	content: RBuilder.() -> Unit,
) {
	render(element = react.element(content), callback = callback)
}
