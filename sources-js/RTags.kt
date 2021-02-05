@file:Suppress("NOTHING_TO_INLINE")

package io.fluidsonic.react


public external interface RTags


@RDsl
@Suppress("unused")
public inline fun RTags.tag(name: String): RTag<RTagProps, Any> =
	tagOf(name)


@RDsl
@Suppress("unused")
public inline fun <Tag : RTag<Props, RefElement>, Props : RTagProps, RefElement : Any> RTags.tagOf(name: String): Tag =
	name.unsafeCast<Tag>()
