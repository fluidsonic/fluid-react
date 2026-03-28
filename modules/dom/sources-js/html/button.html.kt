@file:Suppress("ERROR_SUPPRESSION", "NAME_CONTAINS_ILLEGAL_CHARS", "NESTED_CLASS_IN_EXTERNAL_INTERFACE", "NOTHING_TO_INLINE")

package io.fluidsonic.react

import org.w3c.dom.*


/** Props for the HTML `<button>` element. */
public external interface HTMLButtonProps : HTMLProps {

	public var disabled: Boolean?
	public var formTarget: String?
	public var type: HTMLButtonType?
}


/** Type-safe representation of HTML button types (`"button"`, `"reset"`, `"submit"`). */
@JsName("0;0")
public external interface HTMLButtonType {

	public companion object
}


/** The `"button"` button type. */
public inline val HTMLButtonType.Companion.button: HTMLButtonType get() = unsafe("button")

/** The `"reset"` button type. */
public inline val HTMLButtonType.Companion.reset: HTMLButtonType get() = unsafe("reset")

/** The `"submit"` button type. */
public inline val HTMLButtonType.Companion.submit: HTMLButtonType get() = unsafe("submit")


/** Creates an [HTMLButtonType] from a raw string [value]. */
public inline fun HTMLButtonType.Companion.unsafe(value: String): HTMLButtonType =
	value.unsafeCast<HTMLButtonType>()


/** The HTML `<button>` tag. */
@Suppress("unused")
public inline val RTags.button: HTMLTag<HTMLButtonProps, HTMLButtonElement>
	get() = tagOf("button")
