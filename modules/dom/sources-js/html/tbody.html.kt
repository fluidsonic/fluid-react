package io.fluidsonic.react

import org.w3c.dom.*


/** Props for HTML table section elements (`<tbody>`, `<thead>`, `<tfoot>`). */
public external interface HTMLTableSectionProps : HTMLProps


/** The HTML `<tbody>` tag. */
@Suppress("unused")
public inline val RTags.tbody: HTMLTag<HTMLTableProps, HTMLTableSectionElement>
	get() = tagOf("tbody")
