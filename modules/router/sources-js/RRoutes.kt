package io.fluidsonic.react.router

import io.fluidsonic.react.*
import io.fluidsonic.react.router.external.*


@PublishedApi
internal external interface RRoutesProps : RProps.WithChildren {

	var basename: String?
}


@RDsl
public inline fun RBuilder.Routes(
	basename: String? = undefined,
	content: RBuilder.() -> Unit,
) {
	ReactRouter_Routes::class {
		attrs.basename = basename

		content()
	}
}
