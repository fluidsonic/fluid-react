package io.fluidsonic.react


import io.fluidsonic.react.external.*


@PublishedApi
internal external interface RSuspenseProps : RProps.WithChildren {

	var fallback: RElement?
}


@RDsl
@Suppress("FunctionName")
public inline fun RBuilder.Suspense(
	fallback: RElement?,
	key: String? = null,
	content: RBuilder.() -> Unit,
) {
	External_Suspense(key = key) {
		attrs.fallback = fallback
		content()
	}
}
