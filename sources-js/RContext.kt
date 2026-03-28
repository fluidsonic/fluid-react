package io.fluidsonic.react


/** A React context that holds a [Value]. Wraps `React.Context`. */
@Suppress("PropertyName")
public external interface RContext<Value> {

	public val Consumer: RConsumer<Value>
	public val Provider: RProvider<Value>
}


/** A React context consumer component. Wraps `Context.Consumer`. */
public external interface RConsumer<Value> : RElementFactory<RConsumer.Props<Value>> {

	public interface Props<Value> : RProps {

		public fun children(value: Value): RChildren?
	}
}


/** A React context provider component. Wraps `Context.Provider`. */
public external interface RProvider<Value> : RElementFactory<RProvider.Props<Value>> {

	public interface Props<Value> : RProps.WithChildren {

		public val value: Value
	}
}
