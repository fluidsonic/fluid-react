package io.fluidsonic.react

import org.w3c.dom.*


/** Props for the HTML `<dialog>` element. */
public external interface HTMLDialogProps : HTMLProps


/** The HTML `<dialog>` tag. */
@Suppress("unused")
public inline val RTags.dialog: HTMLTag<HTMLDialogProps, HTMLDialogElement>
	get() = tagOf("dialog")
