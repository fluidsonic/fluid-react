@file:Suppress("NOTHING_TO_INLINE")

package io.fluidsonic.react


/** Namespace interface providing access to HTML and SVG tag factories. */
public external interface RTags


/** Creates an [RTag] for the given tag [name]. */
@Suppress("unused")
public inline fun RTags.tag(name: String): RTag<RTagProps, Any> =
	tagOf(name)


/** Creates a typed [RTag] for the given tag [name]. */
@Suppress("unused")
public inline fun <Tag : RTag<Props, RefElement>, Props : RTagProps, RefElement : Any> RTags.tagOf(name: String): Tag =
	name.unsafeCast<Tag>()
