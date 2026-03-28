package io.fluidsonic.react

import org.w3c.dom.*


/** Props for the HTML `<meta>` element. */
public external interface HTMLMetaProps : HTMLProps {

	public var charSet: String?
	public var content: String?
	public var httpEquiv: String?
	public var name: String?
	public var property: String? // Open Graph
}


/** The HTML `<meta>` tag. */
@Suppress("unused")
public inline val RTags.meta: HTMLTag<HTMLMetaProps, HTMLMetaElement>
	get() = tagOf("meta")
