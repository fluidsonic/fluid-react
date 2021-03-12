package io.fluidsonic.react

import org.w3c.dom.*


public external interface HTMLBaseProps : HTMLProps {

	public var href: String?
	public var target: String?
}


@RDsl
@Suppress("unused")
public inline val RTags.base: HTMLTag<HTMLBaseProps, HTMLBaseElement>
	get() = tagOf("base")
