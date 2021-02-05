package io.fluidsonic.react

import org.w3c.dom.svg.*


public external interface SVGSVGProps : SVGProps


@RDsl
@Suppress("unused")
public inline val RTags.svg: SVGTag<SVGSVGProps, SVGSVGElement>
	get() = tagOf("svg")
