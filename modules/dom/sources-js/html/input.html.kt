@file:Suppress("NAME_CONTAINS_ILLEGAL_CHARS", "NESTED_CLASS_IN_EXTERNAL_INTERFACE", "NOTHING_TO_INLINE")

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


@JsName("0;0")
public external interface HTMLInputType {

	public companion object
}


public inline val HTMLInputType.Companion.button: HTMLInputType get() = unsafe("button")
public inline val HTMLInputType.Companion.checkbox: HTMLInputType get() = unsafe("checkbox")
public inline val HTMLInputType.Companion.color: HTMLInputType get() = unsafe("color")
public inline val HTMLInputType.Companion.date: HTMLInputType get() = unsafe("date")
public inline val HTMLInputType.Companion.datetimeLocal: HTMLInputType get() = unsafe("datetime-local")
public inline val HTMLInputType.Companion.email: HTMLInputType get() = unsafe("email")
public inline val HTMLInputType.Companion.file: HTMLInputType get() = unsafe("file")
public inline val HTMLInputType.Companion.hidden: HTMLInputType get() = unsafe("hidden")
public inline val HTMLInputType.Companion.image: HTMLInputType get() = unsafe("image")
public inline val HTMLInputType.Companion.month: HTMLInputType get() = unsafe("month")
public inline val HTMLInputType.Companion.number: HTMLInputType get() = unsafe("number")
public inline val HTMLInputType.Companion.password: HTMLInputType get() = unsafe("password")
public inline val HTMLInputType.Companion.radio: HTMLInputType get() = unsafe("radio")
public inline val HTMLInputType.Companion.range: HTMLInputType get() = unsafe("range")
public inline val HTMLInputType.Companion.reset: HTMLInputType get() = unsafe("reset")
public inline val HTMLInputType.Companion.search: HTMLInputType get() = unsafe("search")
public inline val HTMLInputType.Companion.submit: HTMLInputType get() = unsafe("submit")
public inline val HTMLInputType.Companion.tel: HTMLInputType get() = unsafe("tel")
public inline val HTMLInputType.Companion.text: HTMLInputType get() = unsafe("text")
public inline val HTMLInputType.Companion.time: HTMLInputType get() = unsafe("time")
public inline val HTMLInputType.Companion.url: HTMLInputType get() = unsafe("url")
public inline val HTMLInputType.Companion.week: HTMLInputType get() = unsafe("week")


public inline fun HTMLInputType.Companion.unsafe(value: String): HTMLInputType =
	value.unsafeCast<HTMLInputType>()


@RDsl
@Suppress("unused")
public inline val RTags.input: HTMLTag<HTMLInputProps, HTMLInputElement>
	get() = tagOf("input")
