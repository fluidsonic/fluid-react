package io.fluidsonic.react

import org.w3c.dom.*


/** Props for the HTML `<br>` element. */
public external interface HTMLBRProps : HTMLProps {

	public var clear: String?
}


/** The HTML `<br>` tag. */
@Suppress("unused")
public inline val RTags.br: HTMLTag<HTMLBRProps, HTMLBRElement>
	get() = tagOf("br")
