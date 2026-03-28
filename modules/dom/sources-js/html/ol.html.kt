package io.fluidsonic.react

import org.w3c.dom.*


/** Props for the HTML `<ol>` element. */
public external interface HTMLOListProps : HTMLProps


/** The HTML `<ol>` (ordered list) tag. */
@Suppress("unused")
public inline val RTags.ol: HTMLTag<HTMLOListProps, HTMLOListElement>
	get() = tagOf("ol")
