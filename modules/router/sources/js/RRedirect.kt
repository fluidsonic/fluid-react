package io.fluidsonic.react.router

import io.fluidsonic.react.*
import io.fluidsonic.react.router.external.*


public external interface RRedirectProps : RProps {

	public var exact: Boolean?
	public var from: String?
	public var path: String?
	public var push: Boolean?
	public var sensitive: Boolean?
	public var strict: Boolean?
	public var to: RRouterLocationDescriptorOrString
}


@RDsl
@Suppress("FunctionName")
public inline fun RBuilder.Redirect(
	to: String,
	exact: Boolean = true,
	from: String? = null,
	path: String? = null,
	push: Boolean = false,
	sensitive: Boolean = true,
	strict: Boolean = true,
) {
	Redirect(
		to = RRouterLocationDescriptor(to),
		exact = exact,
		from = from,
		path = path,
		push = push,
		sensitive = sensitive,
		strict = strict,
	)
}


@RDsl
@Suppress("FunctionName")
public inline fun RBuilder.Redirect(
	to: RRouterLocationDescriptorOrString,
	exact: Boolean = true,
	from: String? = null,
	path: String? = null,
	push: Boolean = false,
	sensitive: Boolean = true,
	strict: Boolean = true,
) {
	ReactRouter_Redirect::class {
		attrs.exact = exact
		from?.let { attrs.from = it }
		path?.let { attrs.path = it }
		attrs.push = push
		attrs.sensitive = sensitive
		attrs.strict = strict
		attrs.to = to
	}
}
