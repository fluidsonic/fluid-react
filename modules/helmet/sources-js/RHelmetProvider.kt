package io.fluidsonic.react.helmet

import io.fluidsonic.react.*
import io.fluidsonic.react.helmet.external.*


@PublishedApi
internal external interface RHelmetProviderProps : RProps.WithChildren {

	var context: dynamic
}


@RDsl
@Suppress("FunctionName")
public inline fun RBuilder.HelmetProvider(
	context: dynamic = null,
	content: RBuilder.() -> Unit,
) {
	ReactHelmet_HelmetProvider::class {
		if (context != null) attrs.context = context

		content()
	}
}
