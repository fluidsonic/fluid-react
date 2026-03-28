package io.fluidsonic.react


/** A renderable function that can be invoked within an [RBuilder] scope. */
public interface RFunction {

	/** Renders this function's content in the given [RBuilder] scope. */
	public operator fun RBuilder.invoke()
}


/** A renderable function with one parameter that can be invoked within an [RBuilder] scope. */
public interface RFunction1<in P1> {

	/** Renders this function's content with the given parameter in the [RBuilder] scope. */
	public operator fun RBuilder.invoke(p1: P1)
}
