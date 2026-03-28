package io.fluidsonic.react

import org.w3c.dom.*


/** Props for HTML heading elements (`<h1>` through `<h6>`). */
public external interface HTMLHeadingProps : HTMLProps


/** The HTML `<h1>` tag. */
@Suppress("unused")
public inline val RTags.h1: HTMLTag<HTMLHeadingProps, HTMLHeadingElement>
	get() = tagOf("h1")


/** The HTML `<h2>` tag. */
@Suppress("unused")
public inline val RTags.h2: HTMLTag<HTMLHeadingProps, HTMLHeadingElement>
	get() = tagOf("h2")


/** The HTML `<h3>` tag. */
@Suppress("unused")
public inline val RTags.h3: HTMLTag<HTMLHeadingProps, HTMLHeadingElement>
	get() = tagOf("h3")


/** The HTML `<h4>` tag. */
@Suppress("unused")
public inline val RTags.h4: HTMLTag<HTMLHeadingProps, HTMLHeadingElement>
	get() = tagOf("h4")


/** The HTML `<h5>` tag. */
@Suppress("unused")
public inline val RTags.h5: HTMLTag<HTMLHeadingProps, HTMLHeadingElement>
	get() = tagOf("h5")


/** The HTML `<h6>` tag. */
@Suppress("unused")
public inline val RTags.h6: HTMLTag<HTMLHeadingProps, HTMLHeadingElement>
	get() = tagOf("h6")
