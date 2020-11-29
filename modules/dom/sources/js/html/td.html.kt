package io.fluidsonic.react

import org.w3c.dom.*


public external interface HTMLTableDataCellProps : HTMLProps


@RDsl
@Suppress("unused")
public inline val RTags.td: HTMLTag<HTMLTableDataCellProps, HTMLTableCellElement>
	get() = tagOf("td")
