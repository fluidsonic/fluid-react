package io.fluidsonic.react


public interface RFunction {

	public operator fun RBuilder.invoke()
}


public interface RFunction1<in P1> {

	public operator fun RBuilder.invoke(p1: P1)
}
