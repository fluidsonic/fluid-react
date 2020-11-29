package io.fluidsonic.react

import org.w3c.dom.*


public external interface HTMLFormProps : HTMLProps


@RDsl
@Suppress("unused")
public inline val RTags.form: HTMLTag<HTMLFormProps, HTMLElement>
	get() = tagOf("form")
