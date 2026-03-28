package io.fluidsonic.react


/** Base interface for React component props. Wraps React's props concept. */
public external interface RProps {

	/** Props interface that supports child elements via the [children] property. */
	public interface WithChildren : RProps {

		public val children: RChildren?
	}
}
