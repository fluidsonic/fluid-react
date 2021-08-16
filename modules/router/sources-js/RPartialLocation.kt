@file:Suppress("NOTHING_TO_INLINE")

package io.fluidsonic.react.router

import io.fluidsonic.react.*


public external interface RPartialLocation<out State> : RPartialPath {

	public val key: String?
	public val state: State?
}


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
