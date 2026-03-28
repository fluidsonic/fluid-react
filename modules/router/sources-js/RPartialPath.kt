package io.fluidsonic.react.router

import io.fluidsonic.react.*


/** A partial URL path with optional [pathname], [search], and [hash] components. */
public external interface RPartialPath {

	public val hash: String?
	public val pathname: String?
	public val search: String?
}


/** Creates a partial path with optional URL components. */
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
