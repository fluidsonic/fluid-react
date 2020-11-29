package io.fluidsonic.react

import org.w3c.dom.*


@RDsl
@Suppress("unused")
public inline val RTags.main: HTMLTag<HTMLProps, HTMLElement>
	get() = tagOf("main")
