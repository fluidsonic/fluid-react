@file:Suppress(
	"INLINE_EXTERNAL_DECLARATION",
	"NESTED_CLASS_IN_EXTERNAL_INTERFACE",
	"NOTHING_TO_INLINE",
	"WRONG_BODY_OF_EXTERNAL_DECLARATION",
)

package io.fluidsonic.react

import org.w3c.dom.*


public external interface HTMLButtonProps : HTMLProps {

	public var disabled: Boolean?
	public var formTarget: String?
	public var type: HTMLButtonType?
}


public external interface HTMLButtonType {

	public companion object {

		public inline val button: HTMLButtonType get() = unsafe("button")
		public inline val reset: HTMLButtonType get() = unsafe("reset")
		public inline val submit: HTMLButtonType get() = unsafe("submit")


		public inline fun unsafe(value: String): HTMLButtonType =
			value.unsafeCast<HTMLButtonType>()
	}
}


@RDsl
@Suppress("unused")
public inline val RTags.button: HTMLTag<HTMLButtonProps, HTMLButtonElement>
	get() = tagOf("button")
