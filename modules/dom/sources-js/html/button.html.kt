@file:Suppress("NAME_CONTAINS_ILLEGAL_CHARS", "NESTED_CLASS_IN_EXTERNAL_INTERFACE", "NOTHING_TO_INLINE")

package io.fluidsonic.react

import org.w3c.dom.*


public external interface HTMLButtonProps : HTMLProps {

	public var disabled: Boolean?
	public var formTarget: String?
	public var type: HTMLButtonType?
}


@JsName("0;0")
public external interface HTMLButtonType {

	public companion object
}


public inline val HTMLButtonType.Companion.button: HTMLButtonType get() = unsafe("button")
public inline val HTMLButtonType.Companion.reset: HTMLButtonType get() = unsafe("reset")
public inline val HTMLButtonType.Companion.submit: HTMLButtonType get() = unsafe("submit")


public inline fun HTMLButtonType.Companion.unsafe(value: String): HTMLButtonType =
	value.unsafeCast<HTMLButtonType>()


@RDsl
@Suppress("unused")
public inline val RTags.button: HTMLTag<HTMLButtonProps, HTMLButtonElement>
	get() = tagOf("button")
