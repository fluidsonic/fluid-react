@file:Suppress("NOTHING_TO_INLINE")

package io.fluidsonic.react.router


/** A navigation target that can be a string path or a partial path object. Wraps React Router's `To`. */
@Suppress("unused")
public external interface RPathTo


/** Creates a navigation target from a string [path]. */
public inline fun RPathTo(path: String): RPathTo =
	path.unsafeCast<RPathTo>()


/** Creates a navigation target from a partial [path] object. */
public inline fun RPathTo(path: RPartialPath): RPathTo =
	path.unsafeCast<RPathTo>()


/** Creates a navigation target from individual URL components. */
public inline fun RPathTo(
	pathname: String? = undefined,
	search: String? = undefined,
	hash: String? = undefined,
): RPathTo =
	RPathTo(RPartialPath(
		hash = hash,
		pathname = pathname,
		search = search,
	))
