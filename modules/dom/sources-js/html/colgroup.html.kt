package io.fluidsonic.react

import org.w3c.dom.*


public external interface HTMLTableColProps : HTMLProps {

	public var span: Int?
}


@RDsl
@Suppress("unused")
public inline val RTags.col: HTMLTag<HTMLTableColProps, HTMLTableColElement>
	get() = tagOf("col")


@RDsl
@Suppress("unused")
public inline val RTags.colgroup: HTMLTag<HTMLTableColProps, HTMLTableColElement>
	get() = tagOf("colgroup")
