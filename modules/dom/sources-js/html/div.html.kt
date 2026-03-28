package io.fluidsonic.react

import org.w3c.dom.*


/** Props for the HTML `<div>` element. */
public external interface HTMLDivProps : HTMLProps


/** The HTML `<div>` tag. */
@Suppress("unused")
public inline val RTags.div: HTMLTag<HTMLDivProps, HTMLDivElement>
	get() = tagOf("div")
