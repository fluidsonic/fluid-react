package io.fluidsonic.react

import org.w3c.dom.*


/** Props for the HTML `<p>` element. */
public external interface HTMLParagraphProps : HTMLProps


/** The HTML `<p>` (paragraph) tag. */
@Suppress("unused")
public inline val RTags.p: HTMLTag<HTMLParagraphProps, HTMLParagraphElement>
	get() = tagOf("p")
