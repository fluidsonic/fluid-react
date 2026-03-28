@file:Suppress("NOTHING_TO_INLINE")

package io.fluidsonic.react

import io.fluidsonic.react.external.*
import kotlin.js.Promise
import kotlin.reflect.*


/** Main API entry point for React operations such as creating components, elements, and contexts. */
public external interface ReactGlobal


@Deprecated(message = "Use `React`.", replaceWith = ReplaceWith("React"), level = DeprecationLevel.WARNING)
public inline val react: ReactGlobal
	get() = 0.unsafeCast<ReactGlobal>()


/** Main API entry point for React operations. */
public inline val React: ReactGlobal
	get() = 0.unsafeCast<ReactGlobal>()


/** Entry point for accessing HTML and SVG tag factories. */
@Suppress("unused")
public inline val tags: RTags
	get() = 0.unsafeCast<RTags>()


/** Creates a component delegate with no props. Wraps `React.memo()` by default. */
public inline fun ReactGlobal.component(
	memo: Boolean = true,
	noinline render: RBuilder.WithHooks.() -> Unit,
): RComponent.Delegate<Unit> =
	component(name = null, memo = memo, render = render).unsafeCast<RComponent.Delegate<Unit>>()


/** Creates a named component with no props. Wraps `React.memo()` by default. */
public inline fun ReactGlobal.component(
	name: String?,
	memo: Boolean = true,
	noinline render: RBuilder.WithHooks.() -> Unit,
): RComponent<Unit> =
	component(name = name, memo = memo, render = render.unsafeCast<RBuilder.WithHooks.(props: Unit) -> Unit>())


/** Creates a component delegate with typed [Props]. Wraps `React.memo()` by default. */
@OptIn(RMemoWithChildren::class)
public inline fun <Props : Any> ReactGlobal.component(
	memo: Boolean = true,
	noinline render: RBuilder.WithHooks.(props: Props) -> Unit,
): RComponent.Delegate<Props> =
	component(name = null, memo = memo, render = render).unsafeCast<RComponent.Delegate<Props>>()


/** Creates a named component with typed [Props]. Wraps `React.memo()` by default. */
@OptIn(RMemoWithChildren::class)
public inline fun <Props : Any> ReactGlobal.component(
	name: String?,
	memo: Boolean = true,
	crossinline render: RBuilder.WithHooks.(props: Props) -> Unit,
): RComponent<Props> {
	val componentFunction = { props: RComponentProps<Props> ->
		element(RElementBuilder().apply { render(props.props) }.elements)
	}

	return componentFunction.unsafeCast<RComponent<Props>>()
		.also { component ->
			if (!isProduction() && name != null)
				component.displayName = name
		}
		.let { if (memo) it.memo() else it }
}


/** Creates a component delegate with no props that accepts children. */
public inline fun ReactGlobal.componentWithChildren(
	noinline render: RBuilder.WithHooks.(children: RChildren?) -> Unit,
): RComponent.WithChildren.Delegate<Unit> =
	componentWithChildren(name = null, render = render).unsafeCast<RComponent.WithChildren.Delegate<Unit>>()


/** Creates a named component with no props that accepts children. */
public inline fun ReactGlobal.componentWithChildren(
	name: String?,
	crossinline render: RBuilder.WithHooks.(children: RChildren?) -> Unit,
): RComponent.WithChildren<Unit> {
	val componentFunction = { props: RComponentProps.WithChildren<Unit> ->
		element(RElementBuilder().apply { render(props.children) }.elements)
	}

	return componentFunction.unsafeCast<RComponent.WithChildren<Unit>>()
		.also { component ->
			if (!isProduction() && name != null)
				component.displayName = name
		}
}


/** Creates a component delegate with typed [Props] that accepts children. */
@Suppress("unused")
public inline fun <Props : Any> ReactGlobal.componentWithChildren(
	noinline render: RBuilder.WithHooks.(props: Props, children: RChildren?) -> Unit,
): RComponent.WithChildren.Delegate<Props> =
	componentWithChildren(name = null, render = render).unsafeCast<RComponent.WithChildren.Delegate<Props>>()


/** Creates a named component with typed [Props] that accepts children. */
@Suppress("unused")
public inline fun <Props : Any> ReactGlobal.componentWithChildren(
	name: String?,
	crossinline render: RBuilder.WithHooks.(props: Props, children: RChildren?) -> Unit,
): RComponent.WithChildren<Props> {
	val componentFunction = { props: RComponentProps.WithChildren<Props> ->
		element(RElementBuilder().apply { render(props.props, props.children) }.elements)
	}

	return componentFunction.unsafeCast<RComponent.WithChildren<Props>>()
		.also { component ->
			if (!isProduction() && name != null)
				component.displayName = name
		}
}


/** Creates a React context with a nullable default value of `null`. Wraps `React.createContext()`. */
@Suppress("unused")
public inline fun <Value : Any> ReactGlobal.context(): RContext<Value?> =
	context(defaultValue = null)


/** Creates a React context with the given [defaultValue]. Wraps `React.createContext()`. */
@Suppress("unused")
public inline fun <Value> ReactGlobal.context(defaultValue: Value): RContext<Value> =
	external_createContext(defaultValue)


/** Creates a React element from a builder [content] block. */
@Suppress("unused")
public inline fun ReactGlobal.element(content: RBuilder.() -> Unit): RElement? =
	element(RElementBuilder().apply(content).elements)


/** Creates a React element from a nullable array of child [elements]. Returns `null` if the array is `null`. */
@Suppress("unused")
public inline fun ReactGlobal.element(elements: Array<out RElement?>?): RElement? =
	elements?.let(::element)


/** Creates a React element from an array of child [elements], wrapping in a fragment if needed. */
@Suppress("unused")
public inline fun ReactGlobal.element(elements: Array<out RElement?>): RElement? =
	react_element(elements)


/** Creates a React element from a [text] string. */
@Suppress("unused")
public inline fun ReactGlobal.element(text: String): RElement =
	text.unsafeCast<RElement>()


/** Creates a React element from a nullable [text] string. */
@Suppress("unused")
public inline fun ReactGlobal.element(text: String?): RElement? =
	text.unsafeCast<RElement?>()


/** Creates a React element for a component with no props. */
public inline fun ReactGlobal.element(component: RComponent<Unit>, key: String? = null): RElement? =
	element(component = component, props = Unit, key = key)


/** Creates a React element for a component with no props that accepts children. */
public inline fun ReactGlobal.element(component: RComponent.WithChildren<Unit>, key: String? = null, content: RBuilder.() -> Unit): RElement? =
	element(component = component, props = Unit, key = key, content = content)


/** Creates a React element for a component with the given [props]. */
@Suppress("unused")
public inline fun <Props : Any> ReactGlobal.element(component: RComponent<Props>, props: Props, key: String? = null): RElement? =
	element(factory = component.asFactory(), props = RComponentProps(props), key = key)


/** Creates a React element for a component with [props] that accepts children. */
@Suppress("unused")
public inline fun <Props : Any> ReactGlobal.element(
	component: RComponent.WithChildren<Props>,
	props: Props,
	key: String? = null,
	content: RBuilder.() -> Unit,
): RElement? =
	element(factory = component.asFactory(), props = RComponentPropsWithChildren(props), key = key, content = content)


/** Creates a React element from an external component class with no custom props. */
@Suppress("unused")
public inline fun ReactGlobal.element(
	factoryClass: KClass<out RElementFactoryClass<in RProps.WithChildren>>,
	key: String? = null,
	ref: RMutableRef<*>? = null,
): RElement? =
	element(factory = factoryClass.asFactory(), key = key, ref = ref)


/** Creates a React element from an external component class with children. */
@Suppress("unused")
public inline fun ReactGlobal.element(
	factoryClass: KClass<out RElementFactoryClass<RProps.WithChildren>>,
	key: String? = null,
	ref: RMutableRef<*>? = null,
	content: RBuilder.() -> Unit,
): RElement? =
	element(factory = factoryClass.asFactory(), key = key, ref = ref, content = content)


/** Creates a React element from an external component class with typed attrs. */
@Suppress("unused")
public inline fun <Props : RProps> ReactGlobal.element(
	factoryClass: KClass<out RElementFactoryClass<Props>>,
	key: String? = null,
	ref: RMutableRef<*>? = null,
	content: RBuilder.WithAttrs<Props>.() -> Unit,
): RElement? =
	element(factory = factoryClass.asFactory(), key = key, ref = ref, content = content)


/** Creates a React element from a factory with no custom props. */
@Suppress("unused")
public inline fun ReactGlobal.element(
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


/** Creates a React element from a factory with children. */
@Suppress("unused")
public inline fun ReactGlobal.element(
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
		children = RElementBuilder().apply(content).elements,
	)


/** Creates a React element from a factory with typed attrs and children. */
// TODO Builder shouldn't allow adding children when Props is not subtype of RProps.WithChildren
@Suppress("unused")
public inline fun <Props : RProps> ReactGlobal.element(
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
		children = builder.elements,
	)
}


/** Creates a React element from a factory with explicit [props]. */
@Suppress("unused")
public inline fun <Props : RProps> ReactGlobal.element(
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


/** Creates a React element from a factory with explicit [props] and children. */
@Suppress("unused")
public inline fun <Props : RProps.WithChildren> ReactGlobal.element(
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
		children = RElementBuilder().apply(content).elements,
	)
}


/*
 * react.element(tag, )
 * react.element(tag, content?)
 * react.element(tag, className?)
 * react.element(tag, className?, content?)
 * react.element(tag, className? = …, key? = …, ref? = …, content? = …)
 */

/** Creates a React element for an HTML/SVG [tag] with no props or children. */
@Suppress("unused")
public inline fun <Props : RTagProps, RefElement : Any> ReactGlobal.element(
	tag: RTag<Props, RefElement>,
) {
	react_element(tag = tag)
}


/** Creates a React element for an HTML/SVG [tag] with a [content] builder. */
@Suppress("unused")
public inline fun <Props : RTagProps, RefElement : Any> ReactGlobal.element(
	tag: RTag<Props, RefElement>,
	noinline content: RBuilder.WithAttrs<Props>.() -> Unit,
) {
	react_element(tag = tag, content = content)
}


/** Creates a React element for an HTML/SVG [tag] with a [className]. */
@Suppress("unused")
public inline fun <Props : RTagProps, RefElement : Any> ReactGlobal.element(
	tag: RTag<Props, RefElement>,
	className: String?,
) {
	react_element(tag = tag, className = className)
}


/** Creates a React element for an HTML/SVG [tag] with a [className] and [content] builder. */
@Suppress("unused")
public inline fun <Props : RTagProps, RefElement : Any> ReactGlobal.element(
	tag: RTag<Props, RefElement>,
	className: String?,
	noinline content: RBuilder.WithAttrs<Props>.() -> Unit,
) {
	react_element(tag = tag, className = className, content = content)
}


/** Creates a React element for an HTML/SVG [tag] with vararg [className], optional [key], [ref], and [content]. */
@Suppress("unused")
public inline fun <Props : RTagProps, RefElement : Any> ReactGlobal.element(
	tag: RTag<Props, RefElement>,
	vararg className: String?,
	key: String? = null,
	ref: RMutableRef<in RefElement?>? = null,
	noinline content: (RBuilder.WithAttrs<Props>.() -> Unit)? = null,
) {
	react_element(tag = tag, className = className, key = key, ref = ref, content = content)
}


/** Creates a React element for an HTML/SVG [tag] with a [className] array, optional [key], [ref], and [content]. */
@Suppress("unused")
public inline fun <Props : RTagProps, RefElement : Any> ReactGlobal.element(
	tag: RTag<Props, RefElement>,
	className: Array<out String?>,
	key: String? = null,
	ref: RMutableRef<in RefElement?>? = null,
	noinline content: (RBuilder.WithAttrs<Props>.() -> Unit)? = null,
) {
	react_element(tag = tag, className = className, key = key, ref = ref, content = content)
}


/** Lazily loads a component module. Wraps `React.lazy()`. */
@Suppress("unused")
public inline fun <Props : RProps> ReactGlobal.lazy(noinline factory: () -> Promise<RElementFactoryModule<Props>>): RElementFactory<Props> =
	external_lazy(factory)


/** Lazily loads a component with no props from a render function. */
@Suppress("unused")
public inline fun ReactGlobal.lazyComponent(crossinline factory: () -> Promise<RBuilder.() -> Unit>): RComponent<Unit> =
	lazyComponent<Unit> {
		factory().then { React.component(name = null, render = it) }
	}


/** Lazily loads a component with typed props. */
@Suppress("unused")
public inline fun <Props : Any> ReactGlobal.lazyComponent(crossinline factory: () -> Promise<RComponent<Props>>): RComponent<Props> =
	lazy {
		factory().then { component ->
			RElementFactoryModule(component.asFactory())
		}
	}.asComponent()


/** Lazily loads a component with typed props that accepts children. */
@Suppress("unused")
public inline fun <Props : Any> ReactGlobal.lazyComponentWithChildren(
	crossinline factory: () -> Promise<RComponent.WithChildren<Props>>,
): RComponent.WithChildren<Props> =
	lazy {
		factory().then { component ->
			RElementFactoryModule(component.asFactory())
		}
	}.asComponent()


/** Creates a mutable ref initialized to `null`. Wraps `React.createRef()`. */
@Suppress("unused")
public inline fun <Value : Any> ReactGlobal.ref(): RMutableRef<Value?> =
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
	React.element(
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
