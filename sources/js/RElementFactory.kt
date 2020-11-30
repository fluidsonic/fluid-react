@file:Suppress("NOTHING_TO_INLINE")

package io.fluidsonic.react

import io.fluidsonic.react.external.*


public external interface RElementFactory<Props : RProps>


public inline fun (() -> RElement?).asFactory(): RElementFactory<RProps> =
	unsafeCast<RElementFactory<RProps>>()


public inline fun <Props : RProps> ((props: RProps) -> RElement?).asFactory(): RElementFactory<Props> =
	unsafeCast<RElementFactory<Props>>()


public inline fun <Props : RProps> RElementFactory<Props>.memo(): RElementFactory<Props> =
	external_memo(factory = this)


public inline fun <Props : RProps> RElementFactory<Props>.memo(noinline areEqual: (old: Props, new: Props) -> Boolean): RElementFactory<Props> =
	external_memo(factory = this, propsAreEqual = areEqual)


@RMemoWithChildren
public inline fun <Props : RProps.WithChildren> RElementFactory<Props>.memo(): RElementFactory<Props> =
	external_memo(factory = this)


@RMemoWithChildren
public inline fun <Props : RProps.WithChildren> RElementFactory<Props>.memo(
	noinline areEqual: (old: Props, new: Props) -> Boolean,
): RElementFactory<Props> =
	external_memo(factory = this, propsAreEqual = areEqual)
