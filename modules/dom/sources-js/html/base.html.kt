package io.fluidsonic.react

import org.w3c.dom.*


/** Props for the HTML `<base>` element. */
public external interface HTMLBaseProps : HTMLProps {

	public var href: String?
	public var target: String?
}


/** The HTML `<base>` tag. */
@Suppress("unused")
public inline val RTags.base: HTMLTag<HTMLBaseProps, HTMLBaseElement>
	get() = tagOf("base")
