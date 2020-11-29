@file:Suppress("NOTHING_TO_INLINE")

// FIXME memo!

package io.fluidsonic.react


public external interface RComponent<Props : Any> {

	public interface WithChildren<Props : Any> : RComponent<Props>
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
