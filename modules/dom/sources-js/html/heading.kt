package io.fluidsonic.react

import org.w3c.dom.*


public external interface HTMLHeadingProps : HTMLProps


@RDsl
@Suppress("unused")
public inline val RTags.h1: HTMLTag<HTMLHeadingProps, HTMLHeadingElement>
	get() = tagOf("h1")


@RDsl
@Suppress("unused")
public inline val RTags.h2: HTMLTag<HTMLHeadingProps, HTMLHeadingElement>
	get() = tagOf("h2")


@RDsl
@Suppress("unused")
public inline val RTags.h3: HTMLTag<HTMLHeadingProps, HTMLHeadingElement>
	get() = tagOf("h3")


@RDsl
@Suppress("unused")
public inline val RTags.h4: HTMLTag<HTMLHeadingProps, HTMLHeadingElement>
	get() = tagOf("h4")


@RDsl
@Suppress("unused")
public inline val RTags.h5: HTMLTag<HTMLHeadingProps, HTMLHeadingElement>
	get() = tagOf("h5")


@RDsl
@Suppress("unused")
public inline val RTags.h6: HTMLTag<HTMLHeadingProps, HTMLHeadingElement>
	get() = tagOf("h6")
