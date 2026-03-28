package io.fluidsonic.react

import org.w3c.dom.*


/** The HTML `<section>` tag. */
@Suppress("unused")
public inline val RTags.section: HTMLTag<HTMLProps, HTMLElement>
	get() = tagOf("section")
