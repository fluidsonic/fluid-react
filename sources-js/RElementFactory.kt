@file:Suppress("NOTHING_TO_INLINE")

package io.fluidsonic.react

import io.fluidsonic.react.external.*


/** A factory for creating React elements with specific [Props]. Wraps a React component type or function. */
public external interface RElementFactory<Props : RProps>


/** Converts a no-argument render function to an [RElementFactory]. */
public inline fun (() -> RElement?).asFactory(): RElementFactory<RProps> =
	unsafeCast<RElementFactory<RProps>>()


/** Converts a render function that takes props to an [RElementFactory]. */
public inline fun <Props : RProps> ((props: RProps) -> RElement?).asFactory(): RElementFactory<Props> =
	unsafeCast<RElementFactory<Props>>()


/** Memoizes this factory using referential equality for props comparison. Wraps `React.memo()`. */
public inline fun <Props : RProps> RElementFactory<Props>.memo(): RElementFactory<Props> =
	external_memo(factory = this)


/** Memoizes this factory using a custom [areEqual] function for props comparison. Wraps `React.memo()`. */
public inline fun <Props : RProps> RElementFactory<Props>.memo(noinline areEqual: (old: Props, new: Props) -> Boolean): RElementFactory<Props> =
	external_memo(factory = this, propsAreEqual = areEqual)


/** Memoizes this factory with children support using referential equality for props comparison. Wraps `React.memo()`. */
@RMemoWithChildren
public inline fun <Props : RProps.WithChildren> RElementFactory<Props>.memo(): RElementFactory<Props> =
	external_memo(factory = this)


/** Memoizes this factory with children support using a custom [areEqual] function for props comparison. Wraps `React.memo()`. */
@RMemoWithChildren
public inline fun <Props : RProps.WithChildren> RElementFactory<Props>.memo(
	noinline areEqual: (old: Props, new: Props) -> Boolean,
): RElementFactory<Props> =
	external_memo(factory = this, propsAreEqual = areEqual)
