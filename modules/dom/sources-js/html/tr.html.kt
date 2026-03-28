package io.fluidsonic.react

import org.w3c.dom.*


/** Props for the HTML `<tr>` element. */
public external interface HTMLTableRowProps : HTMLProps


/** The HTML `<tr>` (table row) tag. */
@Suppress("unused")
public inline val RTags.tr: HTMLTag<HTMLTableRowProps, HTMLTableRowElement>
	get() = tagOf("tr")
