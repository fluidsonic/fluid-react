package io.fluidsonic.react

import org.w3c.dom.*


@RDsl
@Suppress("unused")
public inline val RTags.i: HTMLTag<HTMLProps, HTMLElement>
	get() = tagOf("i")
