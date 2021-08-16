@file:Suppress("NOTHING_TO_INLINE")

package io.fluidsonic.react.router

import io.fluidsonic.react.*


public external interface RPathPattern
public external interface RPathPatternOptions {

	public val caseSensitive: Boolean?
	public val end: Boolean?
	public val path: String
}


public inline fun RPathPattern(path: String): RPathPattern =
	path.unsafeCast<RPathPattern>()


public inline fun RPathPattern(path: String, caseSensitive: Boolean? = undefined, end: Boolean? = undefined): RPathPattern =
	jsObject<RPathPatternOptions> {
		it.caseSensitive = caseSensitive
		it.end = end
		it.path = path
	}.unsafeCast<RPathPattern>()
