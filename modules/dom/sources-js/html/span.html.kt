package io.fluidsonic.react

import org.w3c.dom.*


public external interface HTMLSpanProps : HTMLProps


@RDsl
@Suppress("unused")
public inline val RTags.span: HTMLTag<HTMLSpanProps, HTMLLIElement>
	get() = tagOf("span")
