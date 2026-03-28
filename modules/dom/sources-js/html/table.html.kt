package io.fluidsonic.react

import org.w3c.dom.*


/** Props for the HTML `<table>` element. */
public external interface HTMLTableProps : HTMLProps


/** The HTML `<table>` tag. */
@Suppress("unused")
public inline val RTags.table: HTMLTag<HTMLTableProps, HTMLTableElement>
	get() = tagOf("table")
