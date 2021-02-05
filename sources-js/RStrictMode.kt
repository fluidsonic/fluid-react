package io.fluidsonic.react

import io.fluidsonic.react.external.*


@RDsl
@Suppress("FunctionName")
public inline fun RBuilder.StrictMode(content: RBuilder.() -> Unit) {
	if (isProduction())
		content()
	else
		External_StrictMode(content = content)
}
