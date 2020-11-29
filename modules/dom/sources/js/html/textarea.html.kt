@file:Suppress(
	"INLINE_EXTERNAL_DECLARATION",
	"NESTED_CLASS_IN_EXTERNAL_INTERFACE",
	"NOTHING_TO_INLINE",
	"WRONG_BODY_OF_EXTERNAL_DECLARATION",
)

package io.fluidsonic.react

import org.w3c.dom.*


public external interface HTMLTextAreaProps : HTMLProps {

	public var autoCapitalize: String?
	public var autoComplete: String?
	public var autoCorrect: String?
	public var autoFocus: Boolean?
	public var disabled: Boolean
	public var placeholder: String?
	public var readOnly: Boolean?
	public var required: Boolean?
	public var spellCheck: String?
	public var type: HTMLInputType?
	public var value: String?
}


@RDsl
@Suppress("unused")
public inline val RTags.textarea: HTMLTag<HTMLTextAreaProps, HTMLTextAreaElement>
	get() = tagOf("textarea")
