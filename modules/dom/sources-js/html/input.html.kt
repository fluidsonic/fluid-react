@file:Suppress("ERROR_SUPPRESSION", "NAME_CONTAINS_ILLEGAL_CHARS", "NESTED_CLASS_IN_EXTERNAL_INTERFACE", "NOTHING_TO_INLINE")

package io.fluidsonic.react

import org.w3c.dom.*


/** Props for the HTML `<input>` element. */
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


/** Type-safe representation of HTML input types (`"text"`, `"password"`, `"email"`, etc.). */
@JsName("0;0")
public external interface HTMLInputType {

	public companion object
}


/** The `"button"` input type. */
public inline val HTMLInputType.Companion.button: HTMLInputType get() = unsafe("button")

/** The `"checkbox"` input type. */
public inline val HTMLInputType.Companion.checkbox: HTMLInputType get() = unsafe("checkbox")

/** The `"color"` input type. */
public inline val HTMLInputType.Companion.color: HTMLInputType get() = unsafe("color")

/** The `"date"` input type. */
public inline val HTMLInputType.Companion.date: HTMLInputType get() = unsafe("date")

/** The `"datetime-local"` input type. */
public inline val HTMLInputType.Companion.datetimeLocal: HTMLInputType get() = unsafe("datetime-local")

/** The `"email"` input type. */
public inline val HTMLInputType.Companion.email: HTMLInputType get() = unsafe("email")

/** The `"file"` input type. */
public inline val HTMLInputType.Companion.file: HTMLInputType get() = unsafe("file")

/** The `"hidden"` input type. */
public inline val HTMLInputType.Companion.hidden: HTMLInputType get() = unsafe("hidden")

/** The `"image"` input type. */
public inline val HTMLInputType.Companion.image: HTMLInputType get() = unsafe("image")

/** The `"month"` input type. */
public inline val HTMLInputType.Companion.month: HTMLInputType get() = unsafe("month")

/** The `"number"` input type. */
public inline val HTMLInputType.Companion.number: HTMLInputType get() = unsafe("number")

/** The `"password"` input type. */
public inline val HTMLInputType.Companion.password: HTMLInputType get() = unsafe("password")

/** The `"radio"` input type. */
public inline val HTMLInputType.Companion.radio: HTMLInputType get() = unsafe("radio")

/** The `"range"` input type. */
public inline val HTMLInputType.Companion.range: HTMLInputType get() = unsafe("range")

/** The `"reset"` input type. */
public inline val HTMLInputType.Companion.reset: HTMLInputType get() = unsafe("reset")

/** The `"search"` input type. */
public inline val HTMLInputType.Companion.search: HTMLInputType get() = unsafe("search")

/** The `"submit"` input type. */
public inline val HTMLInputType.Companion.submit: HTMLInputType get() = unsafe("submit")

/** The `"tel"` input type. */
public inline val HTMLInputType.Companion.tel: HTMLInputType get() = unsafe("tel")

/** The `"text"` input type. */
public inline val HTMLInputType.Companion.text: HTMLInputType get() = unsafe("text")

/** The `"time"` input type. */
public inline val HTMLInputType.Companion.time: HTMLInputType get() = unsafe("time")

/** The `"url"` input type. */
public inline val HTMLInputType.Companion.url: HTMLInputType get() = unsafe("url")

/** The `"week"` input type. */
public inline val HTMLInputType.Companion.week: HTMLInputType get() = unsafe("week")


/** Creates an [HTMLInputType] from a raw string [value]. */
public inline fun HTMLInputType.Companion.unsafe(value: String): HTMLInputType =
	value.unsafeCast<HTMLInputType>()


/** The HTML `<input>` tag. */
@Suppress("unused")
public inline val RTags.input: HTMLTag<HTMLInputProps, HTMLInputElement>
	get() = tagOf("input")
