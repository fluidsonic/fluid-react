package io.fluidsonic.react

import org.w3c.dom.*


/** Props for the HTML `<img>` element. */
public external interface HTMLImageProps : HTMLProps {

	public var alt: String?
	public var src: String?
}


/** The HTML `<img>` tag. */
@Suppress("unused")
public inline val RTags.img: HTMLTag<HTMLImageProps, HTMLElement>
	get() = tagOf("img")
