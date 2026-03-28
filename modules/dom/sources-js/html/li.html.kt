package io.fluidsonic.react

import org.w3c.dom.*


/** Props for the HTML `<li>` element. */
public external interface HTMLLIProps : HTMLProps


/** The HTML `<li>` (list item) tag. */
@Suppress("unused")
public inline val RTags.li: HTMLTag<HTMLLIProps, HTMLLIElement>
	get() = tagOf("li")
