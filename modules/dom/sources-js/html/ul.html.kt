package io.fluidsonic.react

import org.w3c.dom.*


public external interface HTMLUListProps : HTMLProps


@RDsl
@Suppress("unused")
public inline val RTags.ul: HTMLTag<HTMLUListProps, HTMLOListElement>
	get() = tagOf("ul")
