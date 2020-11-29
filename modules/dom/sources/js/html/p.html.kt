package io.fluidsonic.react

import org.w3c.dom.*


public external interface HTMLParagraphProps : HTMLProps


@RDsl
@Suppress("unused")
public inline val RTags.p: HTMLTag<HTMLParagraphProps, HTMLParagraphElement>
	get() = tagOf("p")
