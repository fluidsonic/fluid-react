package io.fluidsonic.react

import org.w3c.dom.*


public external interface HTMLTableHeaderCellProps : HTMLProps


@RDsl
@Suppress("unused")
public inline val RTags.th: HTMLTag<HTMLTableHeaderCellProps, HTMLTableCellElement>
	get() = tagOf("th")
