package io.fluidsonic.react

import org.w3c.dom.*


public external interface HTMLMetaProps : HTMLProps {

	public var charSet: String?
	public var content: String?
	public var httpEquiv: String?
	public var name: String?
	public var property: String? // Open Graph
}


@RDsl
@Suppress("unused")
public inline val RTags.meta: HTMLTag<HTMLMetaProps, HTMLMetaElement>
	get() = tagOf("meta")
