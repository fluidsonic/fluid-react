package io.fluidsonic.react

import org.w3c.dom.*


public external interface HTMLDialogProps : HTMLProps


@RDsl
@Suppress("unused")
public inline val RTags.dialog: HTMLTag<HTMLDialogProps, HTMLDialogElement>
	get() = tagOf("dialog")
