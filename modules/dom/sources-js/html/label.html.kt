package io.fluidsonic.react

import org.w3c.dom.*


public external interface HTMLLabelProps : HTMLProps {

	public var htmlFor: String?
}


@RDsl
@Suppress("unused")
public inline val RTags.label: HTMLTag<HTMLLabelProps, HTMLLabelElement>
	get() = tagOf("label")
