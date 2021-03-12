package io.fluidsonic.react

import org.w3c.dom.*


@RDsl
@Suppress("unused")
public inline val RTags.title: HTMLTag<HTMLProps, HTMLTitleElement>
	get() = tagOf("title")
