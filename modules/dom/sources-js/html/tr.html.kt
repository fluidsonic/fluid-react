package io.fluidsonic.react

import org.w3c.dom.*


public external interface HTMLTableRowProps : HTMLProps


@RDsl
@Suppress("unused")
public inline val RTags.tr: HTMLTag<HTMLTableRowProps, HTMLTableRowElement>
	get() = tagOf("tr")
