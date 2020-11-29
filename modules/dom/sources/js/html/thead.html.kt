package io.fluidsonic.react

import org.w3c.dom.*


@RDsl
@Suppress("unused")
public inline val RTags.thead: HTMLTag<HTMLTableProps, HTMLTableSectionElement>
	get() = tagOf("thead")
