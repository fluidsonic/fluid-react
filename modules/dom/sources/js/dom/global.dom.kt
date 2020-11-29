package io.fluidsonic.react

import org.w3c.dom.*


public external interface DOMProps : RTagProps, RProps.WithChildren {

	public var id: String?
}


public external interface DOMTag<Props : DOMProps, RefElement : Element> : RTag<Props, RefElement>
