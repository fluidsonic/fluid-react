package io.fluidsonic.react

import org.w3c.dom.*


public external interface HTMLAnchorProps : HTMLProps {

	public var href: String?
	public var rel: String?
	public var target: String?
}


@RDsl
@Suppress("unused")
public inline val RTags.a: HTMLTag<HTMLAnchorProps, HTMLAnchorElement>
	get() = tagOf("a")
