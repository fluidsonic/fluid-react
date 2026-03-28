package io.fluidsonic.react

import org.w3c.dom.svg.*


/** Base props interface for SVG elements. */
public external interface SVGProps : DOMProps


/** An SVG tag that produces elements with specific [Props] and an [SVGElement] ref type. */
public external interface SVGTag<Props : SVGProps, RefElement : SVGElement> : DOMTag<Props, RefElement>
