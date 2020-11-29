package io.fluidsonic.react

import org.w3c.dom.*


public external interface HTMLLIProps : HTMLProps


@RDsl
@Suppress("unused")
public inline val RTags.li: HTMLTag<HTMLLIProps, HTMLLIElement>
	get() = tagOf("li")
