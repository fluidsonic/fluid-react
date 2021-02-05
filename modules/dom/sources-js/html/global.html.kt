package io.fluidsonic.react

import org.w3c.dom.*
import org.w3c.dom.clipboard.*
import org.w3c.dom.events.*


public external interface HTMLProps : DOMProps {

	public var onBlur: ((event: FocusEvent) -> Unit)?
	public var onChange: ((event: Event) -> Unit)?
	public var onClick: ((event: MouseEvent) -> Unit)?
	public var onFocus: ((event: FocusEvent) -> Unit)?
	public var onKeyDown: ((event: KeyboardEvent) -> Unit)?
	public var onMouseDown: ((event: MouseEvent) -> Unit)?
	public var onMouseUp: ((event: MouseEvent) -> Unit)?
	public var onMouseMove: ((event: MouseEvent) -> Unit)?
	public var onPaste: ((event: ClipboardEvent) -> Unit)?
	public var onScroll: ((event: UIEvent) -> Unit)?
	public var onSubmit: ((event: KeyboardEvent) -> Unit)? // TODO SubmitEvent
	public var onTouchStart: ((event: TouchEvent) -> Unit)?
	public var onTransitionEnd: ((event: TransitionEvent) -> Unit)?
	public var tabIndex: Int?
}


public external interface HTMLTag<Props : HTMLProps, RefElement : HTMLElement> : DOMTag<Props, RefElement>
