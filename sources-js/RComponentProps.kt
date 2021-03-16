@file:Suppress("NOTHING_TO_INLINE")

package io.fluidsonic.react


@PublishedApi
internal external interface RComponentProps<out Props : Any> : RProps {

	val props: Props


	interface WithChildren<out Props : Any> : RComponentProps<Props>, RProps.WithChildren
}


@PublishedApi
internal inline fun <Props : Any> RComponentProps(props: Props): RComponentProps<Props> =
	jsObject { it.props = props }


@PublishedApi
internal inline fun <Props : Any> RComponentPropsWithChildren(props: Props): RComponentProps.WithChildren<Props> =
	jsObject { it.props = props }
