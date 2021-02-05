@file:Suppress(
	"INLINE_EXTERNAL_DECLARATION",
	"NESTED_CLASS_IN_EXTERNAL_INTERFACE",
	"NOTHING_TO_INLINE",
	"WRONG_BODY_OF_EXTERNAL_DECLARATION",
)

package io.fluidsonic.react

import org.w3c.dom.*


public external interface HTMLInputProps : HTMLProps {

	public var autoCapitalize: String?
	public var autoComplete: String?
	public var autoCorrect: String?
	public var autoFocus: Boolean?
	public var disabled: Boolean
	public var inputMode: String?
	public var maxLength: Int?
	public var placeholder: String?
	public var readOnly: Boolean?
	public var required: Boolean?
	public var spellCheck: String?
	public var type: HTMLInputType?
	public var value: String?
}


public external interface HTMLInputType {

	public companion object {

		public inline val button: HTMLInputType get() = unsafe("button")
		public inline val checkbox: HTMLInputType get() = unsafe("checkbox")
		public inline val color: HTMLInputType get() = unsafe("color")
		public inline val date: HTMLInputType get() = unsafe("date")
		public inline val datetimeLocal: HTMLInputType get() = unsafe("datetime-local")
		public inline val email: HTMLInputType get() = unsafe("email")
		public inline val file: HTMLInputType get() = unsafe("file")
		public inline val hidden: HTMLInputType get() = unsafe("hidden")
		public inline val image: HTMLInputType get() = unsafe("image")
		public inline val month: HTMLInputType get() = unsafe("month")
		public inline val number: HTMLInputType get() = unsafe("number")
		public inline val password: HTMLInputType get() = unsafe("password")
		public inline val radio: HTMLInputType get() = unsafe("radio")
		public inline val range: HTMLInputType get() = unsafe("range")
		public inline val reset: HTMLInputType get() = unsafe("reset")
		public inline val search: HTMLInputType get() = unsafe("search")
		public inline val submit: HTMLInputType get() = unsafe("submit")
		public inline val tel: HTMLInputType get() = unsafe("tel")
		public inline val text: HTMLInputType get() = unsafe("text")
		public inline val time: HTMLInputType get() = unsafe("time")
		public inline val url: HTMLInputType get() = unsafe("url")
		public inline val week: HTMLInputType get() = unsafe("week")


		public inline fun unsafe(value: String): HTMLInputType =
			value.unsafeCast<HTMLInputType>()
	}
}


@RDsl
@Suppress("unused")
public inline val RTags.input: HTMLTag<HTMLInputProps, HTMLInputElement>
	get() = tagOf("input")
