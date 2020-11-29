package io.fluidsonic.react

import org.w3c.dom.*


public external interface HTMLOListProps : HTMLProps


@RDsl
@Suppress("unused")
public inline val RTags.ol: HTMLTag<HTMLOListProps, HTMLOListElement>
	get() = tagOf("ol")
