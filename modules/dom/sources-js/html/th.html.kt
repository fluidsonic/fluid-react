package io.fluidsonic.react

import org.w3c.dom.*


/** Props for the HTML `<th>` element. */
public external interface HTMLTableHeaderCellProps : HTMLProps {

	public var colSpan: Int?
	public var headers: String?
	public var rowSpan: Int?
}


/** The HTML `<th>` (table header cell) tag. */
@Suppress("unused")
public inline val RTags.th: HTMLTag<HTMLTableHeaderCellProps, HTMLTableCellElement>
	get() = tagOf("th")
