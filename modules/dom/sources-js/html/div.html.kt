package io.fluidsonic.react

import org.w3c.dom.*


public external interface HTMLDivProps : HTMLProps


@RDsl
@Suppress("unused")
public inline val RTags.div: HTMLTag<HTMLDivProps, HTMLDivElement>
	get() = tagOf("div")
