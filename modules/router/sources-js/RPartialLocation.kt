@file:Suppress("NOTHING_TO_INLINE")

package io.fluidsonic.react.router

import io.fluidsonic.react.*


/** A partial location that may include [key] and [State]. Wraps React Router's `Partial<Location>`. */
public external interface RPartialLocation<out State> : RPartialPath {

	public val key: String?
	public val state: State?
}


/** Creates a partial location with typed [State]. */
public inline fun <State> RPartialLocation(
	pathname: String? = undefined,
	search: String? = undefined,
	hash: String? = undefined,
	key: String? = undefined,
	state: State? = undefined,
): RPartialLocation<State> =
	jsObject<RPartialLocation<State>> {
		it.hash = hash
		it.key = key
		it.pathname = pathname
		it.search = search
		it.state = state
	}.unsafeCast<RPartialLocation<State>>()


/** Creates a partial location with no state. */
public inline fun RPartialLocation(
	pathname: String? = undefined,
	search: String? = undefined,
	hash: String? = undefined,
	key: String? = undefined,
): RPartialLocation<Nothing?> =
	RPartialLocation<Nothing?>(
		hash = hash,
		key = key,
		pathname = pathname,
		search = search,
		state = undefined,
	)
