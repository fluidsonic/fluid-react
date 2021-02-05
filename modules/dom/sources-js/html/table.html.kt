package io.fluidsonic.react

import org.w3c.dom.*


public external interface HTMLTableProps : HTMLProps


@RDsl
@Suppress("unused")
public inline val RTags.table: HTMLTag<HTMLTableProps, HTMLTableElement>
	get() = tagOf("table")
