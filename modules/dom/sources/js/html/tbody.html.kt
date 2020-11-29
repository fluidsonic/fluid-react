package io.fluidsonic.react

import org.w3c.dom.*


public external interface HTMLTableSectionProps : HTMLProps


@RDsl
@Suppress("unused")
public inline val RTags.tbody: HTMLTag<HTMLTableProps, HTMLTableSectionElement>
	get() = tagOf("tbody")
