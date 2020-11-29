package io.fluidsonic.react


public external interface RRef<out Value> {

	public val current: Value
}


public external interface RMutableRef<Value> : RRef<Value> {

	override var current: Value
}
