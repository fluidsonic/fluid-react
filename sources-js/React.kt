@file:Suppress("NOTHING_TO_INLINE")

package io.fluidsonic.react

import io.fluidsonic.react.external.*
import kotlin.js.Promise
import kotlin.reflect.*


public external interface React


@RDsl
public inline val react: React
	get() = 0.unsafeCast<React>()


@RDsl
@Suppress("unused")
public inline val tags: RTags
	get() = 0.unsafeCast<RTags>()


@RDsl
public inline fun React.component(
	memo: Boolean = true,
	crossinline render: RBuilder.WithHooks.() -> Unit,
): RComponent.Delegate<Unit> =
	component(name = null, memo = memo, render = render).unsafeCast<RComponent.Delegate<Unit>>()


@RDsl
public inline fun React.component(
	name: String?,
	memo: Boolean = true,
	crossinline render: RBuilder.WithHooks.() -> Unit,
): RComponent<Unit> =
	component(name = name, memo = memo, render = render.unsafeCast<RBuilder.WithHooks.(props: Unit) -> Unit>())


@OptIn(RMemoWithChildren::class)
@RDsl
public inline fun <Props : Any> React.component(
	memo: Boolean = true,
	crossinline render: RBuilder.WithHooks.(props: Props) -> Unit,
): RComponent.Delegate<Props> =
	component(name = null, memo = memo, render = render).unsafeCast<RComponent.Delegate<Props>>()


@OptIn(RMemoWithChildren::class)
@RDsl
public inline fun <Props : Any> React.component(
	name: String?,
	memo: Boolean = true,
	crossinline render: RBuilder.WithHooks.(props: Props) -> Unit,
): RComponent<Props> {
	val componentFunction = { props: RComponentProps<Props> ->
		element(RElementBuilder().apply { render(props.props) }.buildChildren())
	}

	return componentFunction.unsafeCast<RComponent<Props>>()
		.also { component ->
			if (!isProduction() && name != null)
				component.displayName = name
		}
		.let { if (memo) it.memo() else it }
}


@RDsl
public inline fun React.componentWithChildren(
	crossinline render: RBuilder.WithHooks.(children: RChildren?) -> Unit,
): RComponent.WithChildren.Delegate<Unit> =
	componentWithChildren(name = null, render = render).unsafeCast<RComponent.WithChildren.Delegate<Unit>>()


@RDsl
public inline fun React.componentWithChildren(
	name: String?,
	crossinline render: RBuilder.WithHooks.(children: RChildren?) -> Unit,
): RComponent.WithChildren<Unit> {
	val componentFunction = { props: RComponentProps.WithChildren<Unit> ->
		element(RElementBuilder().apply { render(props.children) }.buildChildren())
	}

	return componentFunction.unsafeCast<RComponent.WithChildren<Unit>>()
		.also { component ->
			if (!isProduction() && name != null)
				component.displayName = name
		}
}


@RDsl
@Suppress("unused")
public inline fun <Props : Any> React.componentWithChildren(
	crossinline render: RBuilder.WithHooks.(props: Props, children: RChildren?) -> Unit,
): RComponent.WithChildren.Delegate<Props> =
	componentWithChildren(name = null, render = render).unsafeCast<RComponent.WithChildren.Delegate<Props>>()


@RDsl
@Suppress("unused")
public inline fun <Props : Any> React.componentWithChildren(
	name: String?,
	crossinline render: RBuilder.WithHooks.(props: Props, children: RChildren?) -> Unit,
): RComponent.WithChildren<Props> {
	val componentFunction = { props: RComponentProps.WithChildren<Props> ->
		element(RElementBuilder().apply { render(props.props, props.children) }.buildChildren())
	}

	return componentFunction.unsafeCast<RComponent.WithChildren<Props>>()
		.also { component ->
			if (!isProduction() && name != null)
				component.displayName = name
		}
}


@RDsl
@Suppress("unused")
public inline fun <Value : Any> React.context(): RContext<Value?> =
	context(defaultValue = null)


@RDsl
@Suppress("unused")
public inline fun <Value> React.context(defaultValue: Value): RContext<Value> =
	external_createContext(defaultValue)


@RDsl
@Suppress("unused")
public inline fun React.element(content: RBuilder.() -> Unit): RElement? =
	element(RElementBuilder().apply(content).buildChildren())


@RDsl
@Suppress("unused")
public inline fun React.element(elements: Array<out RElement?>?): RElement? =
	elements?.let(::element)


@RDsl
@Suppress("unused")
public inline fun React.element(elements: Array<out RElement?>): RElement? =
	react_element(elements)


@RDsl
@Suppress("unused")
public inline fun React.element(text: String): RElement =
	text.unsafeCast<RElement>()


@RDsl
@Suppress("unused")
public inline fun React.element(text: String?): RElement? =
	text.unsafeCast<RElement?>()


@RDsl
public inline fun React.element(component: RComponent<Unit>, key: String? = null): RElement? =
	element(component = component, props = Unit, key = key)


@RDsl
public inline fun React.element(component: RComponent.WithChildren<Unit>, key: String? = null, content: RBuilder.() -> Unit): RElement? =
	element(component = component, props = Unit, key = key, content = content)


@RDsl
@Suppress("unused")
public inline fun <Props : Any> React.element(component: RComponent<Props>, props: Props, key: String? = null): RElement? =
	element(factory = component.asFactory(), props = RComponentProps(props), key = key)


@RDsl
@Suppress("unused")
public inline fun <Props : Any> React.element(
	component: RComponent.WithChildren<Props>,
	props: Props,
	key: String? = null,
	content: RBuilder.() -> Unit,
): RElement? =
	element(factory = component.asFactory(), props = RComponentPropsWithChildren(props), key = key, content = content)


@RDsl
@Suppress("unused")
public inline fun React.element(
	factoryClass: KClass<out RElementFactoryClass<in RProps.WithChildren>>,
	key: String? = null,
	ref: RMutableRef<*>? = null,
): RElement? =
	element(factory = factoryClass.asFactory(), key = key, ref = ref)


@RDsl
@Suppress("unused")
public inline fun React.element(
	factoryClass: KClass<out RElementFactoryClass<RProps.WithChildren>>,
	key: String? = null,
	ref: RMutableRef<*>? = null,
	content: RBuilder.() -> Unit,
): RElement? =
	element(factory = factoryClass.asFactory(), key = key, ref = ref, content = content)


@RDsl
@Suppress("unused")
public inline fun <Props : RProps> React.element(
	factoryClass: KClass<out RElementFactoryClass<Props>>,
	key: String? = null,
	ref: RMutableRef<*>? = null,
	content: RBuilder.WithAttrs<Props>.() -> Unit,
): RElement? =
	element(factory = factoryClass.asFactory(), key = key, ref = ref, content = content)


@RDsl
@Suppress("unused")
public inline fun React.element(
	factory: RElementFactory<in RProps.WithChildren>,
	key: String? = null,
	ref: RMutableRef<*>? = null,
): RElement? =
	react_element(
		factory = factory,
		props = jsObject { props ->
			key?.let { props.key = key }
			ref?.let { props.ref = ref }
		},
		children = null,
	)


@RDsl
@Suppress("unused")
public inline fun React.element(
	factory: RElementFactory<RProps.WithChildren>,
	key: String? = null,
	ref: RMutableRef<*>? = null,
	content: RBuilder.() -> Unit,
): RElement? =
	react_element(
		factory = factory,
		props = jsObject { props ->
			key?.let { props.key = key }
			ref?.let { props.ref = ref }
		},
		children = RElementBuilder().apply(content).buildChildren(),
	)


// TODO Builder shouldn't allow adding children when Props is not subtype of RProps.WithChildren
@RDsl
@Suppress("unused")
public inline fun <Props : RProps> React.element(
	factory: RElementFactory<Props>,
	key: String? = null,
	ref: RMutableRef<*>? = null,
	content: RBuilder.WithAttrs<Props>.() -> Unit,
): RElement? {
	val builder = RElementWithAttrsBuilder<Props>().apply(content)
	key?.let { builder.attrs.asDynamic().key = key }
	ref?.let { builder.attrs.asDynamic().ref = ref }

	return react_element(
		factory = factory,
		props = builder.attrs,
		children = builder.buildChildren(),
	)
}


@RDsl
@Suppress("unused")
public inline fun <Props : RProps> React.element(
	factory: RElementFactory<Props>,
	props: Props,
	key: String? = null,
	ref: RMutableRef<*>? = null,
): RElement? {
	key?.let { props.asDynamic().key = key }
	ref?.let { props.asDynamic().ref = ref }

	return react_element(
		factory = factory,
		props = props,
		children = null,
	)
}


@RDsl
@Suppress("unused")
public inline fun <Props : RProps.WithChildren> React.element(
	factory: RElementFactory<Props>,
	props: Props,
	key: String? = null,
	ref: RMutableRef<*>? = null,
	content: RBuilder.() -> Unit = {},
): RElement? {
	key?.let { props.asDynamic().key = key }
	ref?.let { props.asDynamic().ref = ref }

	return react_element(
		factory = factory,
		props = props,
		children = RElementBuilder().apply(content).buildChildren(),
	)
}


/*
 * react.element(tag, )
 * react.element(tag, content?)
 * react.element(tag, className?)
 * react.element(tag, className?, content?)
 * react.element(tag, className? = …, key? = …, ref? = …, content? = …)
 */

@RDsl
@Suppress("unused")
public inline fun <Props : RTagProps, RefElement : Any> React.element(
	tag: RTag<Props, RefElement>,
) {
	react_element(tag = tag)
}


@RDsl
@Suppress("unused")
public inline fun <Props : RTagProps, RefElement : Any> React.element(
	tag: RTag<Props, RefElement>,
	noinline content: RBuilder.WithAttrs<Props>.() -> Unit,
) {
	react_element(tag = tag, content = content)
}


@RDsl
@Suppress("unused")
public inline fun <Props : RTagProps, RefElement : Any> React.element(
	tag: RTag<Props, RefElement>,
	className: String?,
) {
	react_element(tag = tag, className = className)
}


@RDsl
@Suppress("unused")
public inline fun <Props : RTagProps, RefElement : Any> React.element(
	tag: RTag<Props, RefElement>,
	className: String?,
	noinline content: RBuilder.WithAttrs<Props>.() -> Unit,
) {
	react_element(tag = tag, className = className, content = content)
}


@RDsl
@Suppress("unused")
public inline fun <Props : RTagProps, RefElement : Any> React.element(
	tag: RTag<Props, RefElement>,
	vararg className: String?,
	key: String? = null,
	ref: RMutableRef<in RefElement?>? = null,
	noinline content: (RBuilder.WithAttrs<Props>.() -> Unit)? = null,
) {
	react_element(tag = tag, className = className, key = key, ref = ref, content = content)
}


@RDsl
@Suppress("unused")
public inline fun <Props : RTagProps, RefElement : Any> React.element(
	tag: RTag<Props, RefElement>,
	className: Array<out String?>,
	key: String? = null,
	ref: RMutableRef<in RefElement?>? = null,
	noinline content: (RBuilder.WithAttrs<Props>.() -> Unit)? = null,
) {
	react_element(tag = tag, className = className, key = key, ref = ref, content = content)
}


@RDsl
@Suppress("unused")
public inline fun <Props : RProps> React.lazy(noinline factory: () -> Promise<RElementFactoryModule<Props>>): RElementFactory<Props> =
	external_lazy(factory)


@RDsl
@Suppress("unused")
public inline fun React.lazyComponent(crossinline factory: () -> Promise<RBuilder.() -> Unit>): RComponent<Unit> =
	lazyComponent<Unit> {
		factory().then { react.component(name = null, render = it) }
	}


@RDsl
@Suppress("unused")
public inline fun <Props : Any> React.lazyComponent(crossinline factory: () -> Promise<RComponent<Props>>): RComponent<Props> =
	lazy {
		factory().then { content ->
			RElementFactoryModule(content.asFactory())
		}
	}.asComponent()


@RDsl
@Suppress("unused")
public inline fun <Props : Any> React.lazyComponentWithChildren(
	crossinline factory: () -> Promise<RComponent.WithChildren<Props>>,
): RComponent.WithChildren<Props> =
	lazy {
		factory().then { content ->
			RElementFactoryModule(content.asFactory())
		}
	}.asComponent()


@RDsl
@Suppress("unused")
public inline fun <Value : Any> React.ref(): RMutableRef<Value?> =
	external_createRef()


@PublishedApi
internal /* no-inline */ fun <Props : RProps> react_element(
	factory: RElementFactory<Props>,
	props: Props,
	children: Array<out RElement?>?,
): RElement? =
	external_createElement(
		factory = factory,
		props = props,
		children = children.orEmpty(),
	)


@PublishedApi
internal /* no-inline */ fun react_element(elements: Array<out RElement?>): RElement? =
	when (elements.size) {
		0 -> null
		1 -> elements[0]
		else -> react_element(factory = External_Fragment, props = jsObject(), children = elements)
	}

/*
 * react_element(tag)
 * react_element(tag, content?)
 * react_element(tag, className?)
 * react_element(tag, className?, content?)
 * react_element(tag, className? = …, key? = …, ref? = …, content? = …)
 */

@PublishedApi
internal /* no-inline */ fun <Props : RTagProps, RefElement : Any> react_element(
	tag: RTag<Props, RefElement>,
): RElement? =
	react_element(tag = tag, className = null, key = null, ref = null, content = null)


@PublishedApi
internal /* no-inline */ fun <Props : RTagProps, RefElement : Any> react_element(
	tag: RTag<Props, RefElement>,
	content: (RBuilder.WithAttrs<Props>.() -> Unit)?,
): RElement? =
	react_element(tag = tag, className = null, key = null, ref = null, content = content)


@PublishedApi
internal /* no-inline */ fun <Props : RTagProps, RefElement : Any> react_element(
	tag: RTag<Props, RefElement>,
	className: String?,
): RElement? =
	react_element(tag = tag, className = className, key = null, ref = null, content = null)


@PublishedApi
internal /* no-inline */ fun <Props : RTagProps, RefElement : Any> react_element(
	tag: RTag<Props, RefElement>,
	className: String?,
	content: (RBuilder.WithAttrs<Props>.() -> Unit)?,
): RElement? =
	react_element(tag = tag, className = className, key = null, ref = null, content = content)


@PublishedApi
internal /* no-inline */ fun <Props : RTagProps, RefElement : Any> react_element(
	tag: RTag<Props, RefElement>,
	className: String?,
	key: String?,
	ref: RMutableRef<in RefElement?>?,
	content: (RBuilder.WithAttrs<Props>.() -> Unit)?,
): RElement? =
	react.element(
		factory = tag.asFactory(),
		key = key,
		ref = ref
	) {
		className?.let { attrs.className = it }
		content?.invoke(this)
	}


@PublishedApi
internal /* no-inline */ fun <Props : RTagProps, RefElement : Any> react_element(
	tag: RTag<Props, RefElement>,
	className: Array<out String?>,
	key: String?,
	ref: RMutableRef<in RefElement?>?,
	content: (RBuilder.WithAttrs<Props>.() -> Unit)?,
): RElement? =
	react_element(
		tag = tag,
		className = className.ifEmpty { null }?.join(" "),
		key = key,
		ref = ref,
		content = content,
	)
