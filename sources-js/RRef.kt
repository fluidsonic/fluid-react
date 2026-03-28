package io.fluidsonic.react


/** A read-only reference to a value. Wraps React's `RefObject`. */
public external interface RRef<out Value> {

	public val current: Value
}


/** A mutable reference to a value. Wraps React's `MutableRefObject`. */
public external interface RMutableRef<Value> : RRef<Value> {

	override var current: Value
}
