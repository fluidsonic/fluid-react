@file:Suppress("NOTHING_TO_INLINE")


package io.fluidsonic.react

import kotlin.reflect.*


/** Represents a React component that accepts [Props]. */
public external interface RComponent<Props : Any> {

	/** Property delegate for [RComponent], enabling `val MyComponent by React.component { ... }` syntax. */
	public interface Delegate<Props : Any>


	/** A React component that accepts [Props] and supports child elements. */
	public interface WithChildren<Props : Any> : RComponent<Props> {

		/** Property delegate for [WithChildren], enabling `val MyComponent by React.componentWithChildren { ... }` syntax. */
		public interface Delegate<Props : Any> : RComponent.Delegate<Props>
	}
}


@PublishedApi
internal inline fun <Props : Any> RElementFactory<RComponentProps<Props>>.asComponent(): RComponent<Props> =
	unsafeCast<RComponent<Props>>()


@PublishedApi
internal inline fun <Props : Any> RElementFactory<RComponentProps.WithChildren<Props>>.asComponent(): RComponent.WithChildren<Props> =
	unsafeCast<RComponent.WithChildren<Props>>()


@PublishedApi
internal inline fun <Props : Any> RComponent<Props>.asFactory(): RElementFactory<RComponentProps<Props>> =
	unsafeCast<RElementFactory<RComponentProps<Props>>>()


@PublishedApi
internal inline fun <Props : Any> RComponent.WithChildren<Props>.asFactory(): RElementFactory<RComponentProps.WithChildren<Props>> =
	unsafeCast<RElementFactory<RComponentProps.WithChildren<Props>>>()


@PublishedApi
internal inline var RComponent<*>.displayName: String?
	get() = asDynamic().displayName.unsafeCast<String?>()
	set(value) {
		asDynamic().displayName = value
	}


@PublishedApi
internal inline var RComponent.Delegate<*>.displayName: String?
	get() = asDynamic().displayName.unsafeCast<String?>()
	set(value) {
		asDynamic().displayName = value
	}


/** Allows reading the component from a delegated property. */
public inline operator fun <Props : Any> RComponent.Delegate<Props>.getValue(thisRef: Any?, property: KProperty<*>): RComponent<Props> =
	unsafeCast<RComponent<Props>>()


/** Allows reading the component with children from a delegated property. */
public inline operator fun <Props : Any> RComponent.WithChildren.Delegate<Props>.getValue(
	thisRef: Any?,
	property: KProperty<*>,
): RComponent.WithChildren<Props> =
	unsafeCast<RComponent.WithChildren<Props>>()


/** Memoizes this component using structural equality for props comparison. Wraps `React.memo()`. */
public inline fun <Props : Any> RComponent<Props>.memo(): RComponent<Props> =
	memo { old, new -> old == new }


/** Memoizes this component using a custom [areEqual] function for props comparison. Wraps `React.memo()`. */
public inline fun <Props : Any> RComponent<Props>.memo(noinline areEqual: (old: Props, new: Props) -> Boolean): RComponent<Props> =
	asFactory().memo { old, new -> areEqual(old.props, new.props) }.asComponent()


/** Memoizes this component with children using structural equality for props comparison. Wraps `React.memo()`. */
@RMemoWithChildren
public inline fun <Props : Any> RComponent.WithChildren<Props>.memo(): RComponent.WithChildren<Props> =
	memo { old, new -> old == new }


/** Memoizes this component with children using a custom [areEqual] function for props comparison. Wraps `React.memo()`. */
@RMemoWithChildren
public inline fun <Props : Any> RComponent.WithChildren<Props>.memo(
	noinline areEqual: (old: Props, new: Props) -> Boolean,
): RComponent.WithChildren<Props> =
	asFactory().memo { old, new -> areEqual(old.props, new.props) }.asComponent()


/** Sets the component's display name from the delegated property name (in non-production builds). */
public inline operator fun <Props : Any> RComponent.Delegate<Props>.provideDelegate(thisRef: Any?, property: KProperty<*>): RComponent.Delegate<Props> {
	if (!isProduction()) this.displayName = property.name
	return this
}


/** Sets the component's display name from the delegated property name (in non-production builds). */
public inline operator fun <Props : Any> RComponent.WithChildren.Delegate<Props>.provideDelegate(
	thisRef: Any?,
	property: KProperty<*>,
): RComponent.WithChildren.Delegate<Props> {
	if (!isProduction()) this.displayName = property.name
	return this
}
