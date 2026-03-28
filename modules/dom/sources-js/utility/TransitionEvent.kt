package io.fluidsonic.react

import org.w3c.dom.events.*


/** Represents a CSS transition event. */
public open external class TransitionEvent : UIEvent {

	public val elapsedTime: Double
	public val propertyName: String
	public val pseudoElement: String
}
