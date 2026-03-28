package io.fluidsonic.react

import org.w3c.dom.*


/** Props for the HTML `<form>` element. */
public external interface HTMLFormProps : HTMLProps


/** The HTML `<form>` tag. */
@Suppress("unused")
public inline val RTags.form: HTMLTag<HTMLFormProps, HTMLElement>
	get() = tagOf("form")
