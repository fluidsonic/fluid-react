package io.fluidsonic.react

import org.w3c.dom.*


/** Props for the HTML `<textarea>` element. */
public external interface HTMLTextAreaProps : HTMLProps {

	public var autoCapitalize: String?
	public var autoComplete: String?
	public var autoCorrect: String?
	public var autoFocus: Boolean?
	public var cols: Int?
	public var disabled: Boolean
	public var placeholder: String?
	public var readOnly: Boolean?
	public var required: Boolean?
	public var rows: Int?
	public var spellCheck: String?
	public var type: HTMLInputType?
	public var value: String?
	public var wrap: String?
}


/** The HTML `<textarea>` tag. */
@Suppress("unused")
public inline val RTags.textarea: HTMLTag<HTMLTextAreaProps, HTMLTextAreaElement>
	get() = tagOf("textarea")
