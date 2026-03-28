package io.fluidsonic.react


/** DSL marker annotation for React builder scopes, preventing accidental access to outer scope receivers. */
@DslMarker
@Retention(AnnotationRetention.BINARY)
@Target(AnnotationTarget.CLASS, AnnotationTarget.FUNCTION, AnnotationTarget.PROPERTY, AnnotationTarget.TYPEALIAS)
public annotation class RDsl
