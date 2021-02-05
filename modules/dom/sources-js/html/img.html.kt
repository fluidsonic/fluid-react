package io.fluidsonic.react

import org.w3c.dom.*


public external interface HTMLImageProps : HTMLProps {

	public var alt: String?
	public var src: String?
}


@RDsl
@Suppress("unused")
public inline val RTags.img: HTMLTag<HTMLImageProps, HTMLElement>
	get() = tagOf("img")
