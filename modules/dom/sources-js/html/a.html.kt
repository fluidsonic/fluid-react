package io.fluidsonic.react

import org.w3c.dom.*


/** Props for the HTML `<a>` element. */
public external interface HTMLAnchorProps : HTMLProps {

	public var href: String?
	public var rel: String?
	public var target: String?
}


/** The HTML `<a>` (anchor) tag. */
@Suppress("unused")
public inline val RTags.a: HTMLTag<HTMLAnchorProps, HTMLAnchorElement>
	get() = tagOf("a")
