package io.fluidsonic.react

import org.w3c.dom.*


public external interface HTMLTableHeaderCellProps : HTMLProps {

	public var colSpan: Int?
	public var headers: String?
	public var rowSpan: Int?
}


@RDsl
@Suppress("unused")
public inline val RTags.th: HTMLTag<HTMLTableHeaderCellProps, HTMLTableCellElement>
	get() = tagOf("th")
