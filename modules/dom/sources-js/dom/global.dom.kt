package io.fluidsonic.react

import org.w3c.dom.*


/** Base props interface for DOM elements, extending [RTagProps] with an [id] attribute. */
public external interface DOMProps : RTagProps, RProps.WithChildren {

	public var id: String?
}


/** A DOM tag that produces elements with specific [Props] and a DOM [RefElement] type. */
public external interface DOMTag<Props : DOMProps, RefElement : Element> : RTag<Props, RefElement>
