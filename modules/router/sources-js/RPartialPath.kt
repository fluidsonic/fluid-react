package io.fluidsonic.react.router

import io.fluidsonic.react.*


public external interface RPartialPath {

	public val hash: String?
	public val pathname: String?
	public val search: String?
}


@Suppress("NOTHING_TO_INLINE")
public inline fun RPartialPath(
	pathname: String? = undefined,
	search: String? = undefined,
	hash: String? = undefined,
): RPartialPath =
	jsObject {
		it.hash = hash
		it.pathname = pathname
		it.search = search
	}
