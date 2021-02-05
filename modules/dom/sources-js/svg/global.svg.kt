package io.fluidsonic.react

import org.w3c.dom.svg.*


public external interface SVGProps : DOMProps


public external interface SVGTag<Props : SVGProps, RefElement : SVGElement> : DOMTag<Props, RefElement>
