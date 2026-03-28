package io.fluidsonic.react

import org.w3c.dom.*


/** Props for the HTML `<span>` element. */
public external interface HTMLSpanProps : HTMLProps


/** The HTML `<span>` tag. */
@Suppress("unused")
public inline val RTags.span: HTMLTag<HTMLSpanProps, HTMLLIElement>
	get() = tagOf("span")
