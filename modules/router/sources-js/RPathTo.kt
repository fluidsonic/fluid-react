@file:Suppress("NOTHING_TO_INLINE")

package io.fluidsonic.react.router


@Suppress("unused")
public external interface RPathTo


public inline fun RPathTo(path: String): RPathTo =
	path.unsafeCast<RPathTo>()


public inline fun RPathTo(path: RPartialPath): RPathTo =
	path.unsafeCast<RPathTo>()


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
