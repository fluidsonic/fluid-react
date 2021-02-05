package io.fluidsonic.react


@Suppress("PropertyName")
public external interface RContext<Value> {

	public val Consumer: RConsumer<Value>
	public val Provider: RProvider<Value>
}


public external interface RConsumer<Value> : RElementFactory<RConsumer.Props<Value>> {

	public interface Props<Value> : RProps {

		public fun children(value: Value): RChildren?
	}
}


public external interface RProvider<Value> : RElementFactory<RProvider.Props<Value>> {

	public interface Props<Value> : RProps.WithChildren {

		public val value: Value
	}
}
