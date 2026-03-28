package io.fluidsonic.react

import org.w3c.dom.*


/** Props for the HTML `<label>` element. */
public external interface HTMLLabelProps : HTMLProps {

	public var htmlFor: String?
}


/** The HTML `<label>` tag. */
@Suppress("unused")
public inline val RTags.label: HTMLTag<HTMLLabelProps, HTMLLabelElement>
	get() = tagOf("label")
