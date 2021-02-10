package io.fluidsonic.react

import org.w3c.dom.*


public external interface HTMLBRProps : HTMLProps {

	public var clear: String?
}


@RDsl
@Suppress("unused")
public inline val RTags.br: HTMLTag<HTMLBRProps, HTMLBRElement>
	get() = tagOf("br")
