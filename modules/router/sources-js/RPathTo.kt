@file:Suppress("NOTHING_TO_INLINE")

package io.fluidsonic.react.router


@Suppress("unused")
public external interface RPathTo<out State>


public inline fun RPathTo(path: String): RPathTo<Nothing?> =
	path.unsafeCast<RPathTo<Nothing?>>()


public inline fun <State> RPathTo(location: RPartialLocation<State>): RPathTo<State> =
	location.unsafeCast<RPathTo<State>>()


public inline fun RPathTo(
	pathname: String? = undefined,
	search: String? = undefined,
	hash: String? = undefined,
	key: String? = undefined,
): RPathTo<Nothing?> =
	RPathTo(RPartialLocation(
		hash = hash,
		key = key,
		pathname = pathname,
		search = search,
	))


public inline fun <State> RPathTo(
	pathname: String? = undefined,
	search: String? = undefined,
	hash: String? = undefined,
	key: String? = undefined,
	state: State? = undefined,
): RPathTo<State> =
	RPathTo(RPartialLocation<State>(
		hash = hash,
		key = key,
		pathname = pathname,
		search = search,
		state = state,
	))
