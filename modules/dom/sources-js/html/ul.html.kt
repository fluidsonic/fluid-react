package io.fluidsonic.react

import org.w3c.dom.*


/** Props for the HTML `<ul>` element. */
public external interface HTMLUListProps : HTMLProps


/** The HTML `<ul>` (unordered list) tag. */
@Suppress("unused")
public inline val RTags.ul: HTMLTag<HTMLUListProps, HTMLOListElement>
	get() = tagOf("ul")
