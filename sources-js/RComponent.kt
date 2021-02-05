@file:Suppress("NOTHING_TO_INLINE")


package io.fluidsonic.react

import kotlin.reflect.*


public external interface RComponent<Props : Any> {

	public interface Delegate<Props : Any>


	public interface WithChildren<Props : Any> : RComponent<Props> {

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


public inline operator fun <Props : Any> RComponent.Delegate<Props>.getValue(thisRef: Any?, property: KProperty<*>): RComponent<Props> =
	unsafeCast<RComponent<Props>>()


public inline operator fun <Props : Any> RComponent.WithChildren.Delegate<Props>.getValue(
	thisRef: Any?,
	property: KProperty<*>,
): RComponent.WithChildren<Props> =
	unsafeCast<RComponent.WithChildren<Props>>()


public inline fun <Props : Any> RComponent<Props>.memo(): RComponent<Props> =
	memo { old, new -> old == new }


public inline fun <Props : Any> RComponent<Props>.memo(noinline areEqual: (old: Props, new: Props) -> Boolean): RComponent<Props> =
	asFactory().memo { old, new -> areEqual(old.props, new.props) }.asComponent()


@RMemoWithChildren
public inline fun <Props : Any> RComponent.WithChildren<Props>.memo(): RComponent.WithChildren<Props> =
	memo { old, new -> old == new }


@RMemoWithChildren
public inline fun <Props : Any> RComponent.WithChildren<Props>.memo(
	noinline areEqual: (old: Props, new: Props) -> Boolean,
): RComponent.WithChildren<Props> =
	asFactory().memo { old, new -> areEqual(old.props, new.props) }.asComponent()


public inline operator fun <Props : Any> RComponent.Delegate<Props>.provideDelegate(thisRef: Any?, property: KProperty<*>): RComponent.Delegate<Props> {
	if (!isProduction()) this.displayName = property.name
	return this
}


public inline operator fun <Props : Any> RComponent.WithChildren.Delegate<Props>.provideDelegate(
	thisRef: Any?,
	property: KProperty<*>,
): RComponent.WithChildren.Delegate<Props> {
	if (!isProduction()) this.displayName = property.name
	return this
}
