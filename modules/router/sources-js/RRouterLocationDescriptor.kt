package io.fluidsonic.react.router

import io.fluidsonic.react.*


public external interface RRouterLocationDescriptorOrString
public external interface RRouterLocationDescriptor<out State> : RRouterLocationDescriptorOrString {

	public val hash: String?
	public val key: String?
	public val pathname: String?
	public val search: String?
	public val state: State?
}


public fun RRouterLocationDescriptor(
	pathname: String? = null, // pathname first b/c RRouterLocationDescriptor(String) could be confused with RRouterLocationDescriptorOrString(String)
	hash: String? = null,
	key: String? = null,
	search: String? = null,
): RRouterLocationDescriptor<Nothing?> =
	jsObject {
		it.hash = hash
		it.key = key
		it.pathname = pathname
		it.search = search
		it.state = null
	}


public fun <State> RRouterLocationDescriptor(
	pathname: String? = null, // pathname first b/c RRouterLocationDescriptor(String) could be confused with RRouterLocationDescriptorOrString(String)
	hash: String? = null,
	key: String? = null,
	search: String? = null,
	state: State? = null,
): RRouterLocationDescriptor<State> =
	jsObject {
		it.hash = hash
		it.key = key
		it.pathname = pathname
		it.search = search
		it.state = state
	}


public fun RRouterLocationDescriptorOrString(
	pathname: String,
): RRouterLocationDescriptorOrString =
	pathname.unsafeCast<RRouterLocationDescriptorOrString>()
