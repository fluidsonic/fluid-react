package io.fluidsonic.react

import org.w3c.dom.*


/** Props for the HTML `<col>` and `<colgroup>` elements. */
public external interface HTMLTableColProps : HTMLProps {

	public var span: Int?
}


/** The HTML `<col>` tag. */
@Suppress("unused")
public inline val RTags.col: HTMLTag<HTMLTableColProps, HTMLTableColElement>
	get() = tagOf("col")


/** The HTML `<colgroup>` tag. */
@Suppress("unused")
public inline val RTags.colgroup: HTMLTag<HTMLTableColProps, HTMLTableColElement>
	get() = tagOf("colgroup")
