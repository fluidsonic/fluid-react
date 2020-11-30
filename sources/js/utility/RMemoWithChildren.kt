package io.fluidsonic.react


@RequiresOptIn(
	level = RequiresOptIn.Level.WARNING,
	message = "Memoization of components with children rarely works as expected. See https://github.com/facebook/react/issues/14463 for further information."
)
@Retention(value = AnnotationRetention.BINARY)
@Target(AnnotationTarget.CLASS, AnnotationTarget.FUNCTION, AnnotationTarget.PROPERTY, AnnotationTarget.TYPEALIAS)
public annotation class RMemoWithChildren
