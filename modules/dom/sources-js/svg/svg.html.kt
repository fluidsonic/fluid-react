package io.fluidsonic.react

import org.w3c.dom.svg.*


/** Props for the `<svg>` element. */
public external interface SVGSVGProps : SVGProps


/** The `<svg>` tag. */
@Suppress("unused")
public inline val RTags.svg: SVGTag<SVGSVGProps, SVGSVGElement>
	get() = tagOf("svg")
