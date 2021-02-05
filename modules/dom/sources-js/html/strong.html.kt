package io.fluidsonic.react

import org.w3c.dom.*


@RDsl
@Suppress("unused")
public inline val RTags.strong: HTMLTag<HTMLProps, HTMLElement>
	get() = tagOf("strong")
