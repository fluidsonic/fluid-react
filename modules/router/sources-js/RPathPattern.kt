@file:Suppress("NOTHING_TO_INLINE")

package io.fluidsonic.react.router

import io.fluidsonic.react.*


/** A path pattern used for route matching. Can be a simple string or include options. */
public external interface RPathPattern

/** Options for configuring path pattern matching behavior. */
public external interface RPathPatternOptions {

	public val caseSensitive: Boolean?
	public val end: Boolean?
	public val path: String
}


/** Creates a path pattern from a [path] string. */
public inline fun RPathPattern(path: String): RPathPattern =
	path.unsafeCast<RPathPattern>()


/** Creates a path pattern with matching options. */
public inline fun RPathPattern(path: String, caseSensitive: Boolean? = undefined, end: Boolean? = undefined): RPathPattern =
	jsObject<RPathPatternOptions> {
		it.caseSensitive = caseSensitive
		it.end = end
		it.path = path
	}.unsafeCast<RPathPattern>()
