package io.fluidsonic.react

import org.w3c.dom.*


/** Props for the HTML `<td>` element. */
public external interface HTMLTableDataCellProps : HTMLProps {

	public var colSpan: Int?
	public var headers: String?
	public var rowSpan: Int?
}


/** The HTML `<td>` (table data cell) tag. */
@Suppress("unused")
public inline val RTags.td: HTMLTag<HTMLTableDataCellProps, HTMLTableCellElement>
	get() = tagOf("td")
