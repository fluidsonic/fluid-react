@file:Suppress("NOTHING_TO_INLINE", "WRONG_MODIFIER_CONTAINING_DECLARATION")

package io.fluidsonic.react

import kotlin.reflect.*


/**
 * DSL scope for building React element trees. Provides operators for invoking components, factories, and tags.
 *
 * TODO Use context parameters once available (Kotlin 2.x).
 */
// Was originally an external interface; changed to sealed interface in Kotlin 1.5.20.
@RDsl
public sealed interface RBuilder : RTags {

	/** Appends a React [element] to the current element tree. */
	public fun append(element: RElement?)


	/** Appends this element to the current element tree. */
	public final inline operator fun RElement?.invoke() {
		append(this)
	}


	/** Appends this array of elements to the current element tree. */
	public final inline operator fun Array<out RElement?>?.invoke() {
		append(this)
	}


	/** Renders a component with no props. */
	public final inline operator fun RComponent<Unit>.invoke(key: String? = null) {
		append(React.element(component = this, key = key))
	}


	/** Renders a component with no props that accepts children. */
	public final inline operator fun RComponent.WithChildren<Unit>.invoke(key: String? = null, content: RBuilder.() -> Unit) {
		append(React.element(component = this, key = key, content = content))
	}


	/** Renders a component with the given [props]. */
	public final inline operator fun <Props : Any> RComponent<Props>.invoke(props: Props, key: String? = null) {
		append(React.element(component = this, props = props, key = key))
	}


	/** Renders a component with the given [props] and children. */
	public final inline operator fun <Props : Any> RComponent.WithChildren<Props>.invoke(props: Props, key: String? = null, content: RBuilder.() -> Unit) {
		append(React.element(component = this, props = props, key = key, content = content))
	}


	/** Renders an external component class with no custom props. */
	public final inline operator fun KClass<out RElementFactoryClass<in RProps.WithChildren>>.invoke(key: String? = null, ref: RMutableRef<*>? = null) {
		append(React.element(factoryClass = this, key = key, ref = ref))
	}


	/** Renders an external component class with children. */
	public final inline operator fun KClass<out RElementFactoryClass<RProps.WithChildren>>.invoke(
		key: String? = null,
		ref: RMutableRef<*>? = null,
		content: RBuilder.() -> Unit,
	) {
		append(React.element(factoryClass = this, content = content, key = key, ref = ref))
	}


	/** Renders an external component class with typed attrs. */
	public final inline operator fun <Props : RProps> KClass<out RElementFactoryClass<Props>>.invoke(
		key: String? = null,
		ref: RMutableRef<*>? = null,
		content: WithAttrs<Props>.() -> Unit,
	) {
		append(React.element(factoryClass = this, content = content, key = key, ref = ref))
	}


	/** Renders a factory with no custom props. */
	public final inline operator fun RElementFactory<in RProps.WithChildren>.invoke(key: String? = null, ref: RMutableRef<*>? = null) {
		append(React.element(factory = this, key = key, ref = ref))
	}


	/** Renders a factory with children. */
	public final inline operator fun RElementFactory<RProps.WithChildren>.invoke(
		key: String? = null,
		ref: RMutableRef<*>? = null,
		content: RBuilder.() -> Unit,
	) {
		append(React.element(factory = this, key = key, ref = ref, content = content))
	}


	/** Renders a factory with typed attrs and children. */
	// TODO Builder shouldn't allow adding children when Props is not subtype of RProps.WithChildren
	public final inline operator fun <Props : RProps> RElementFactory<Props>.invoke(
		key: String? = null,
		ref: RMutableRef<*>? = null,
		content: WithAttrs<Props>.() -> Unit,
	) {
		append(React.element(factory = this, key = key, ref = ref, content = content))
	}


	/** Renders a factory with explicit [props]. */
	public final inline operator fun <Props : RProps> RElementFactory<Props>.invoke(
		props: Props,
		key: String? = null,
		ref: RMutableRef<*>? = null,
	) {
		append(React.element(factory = this, props = props, key = key, ref = ref))
	}


	/** Renders a factory with explicit [props] and children. */
	public final inline operator fun <Props : RProps.WithChildren> RElementFactory<Props>.invoke(
		props: Props,
		key: String? = null,
		ref: RMutableRef<*>? = null,
		content: RBuilder.() -> Unit,
	) {
		append(React.element(factory = this, props = props, key = key, ref = ref, content = content))
	}


	/** Invokes an [RFunction] in the current builder scope. Workaround for KT-10468. */
	// Workaround for lack of https://youtrack.jetbrains.com/issue/KT-10468
	public final inline operator fun RFunction.invoke() {
		this@RBuilder.invoke()
	}


	/** Invokes an [RFunction1] with one parameter in the current builder scope. Workaround for KT-10468. */
	// Workaround for lack of https://youtrack.jetbrains.com/issue/KT-10468
	public final inline operator fun <P1> RFunction1<P1>.invoke(p1: P1) {
		this@RBuilder.invoke(p1)
	}


	/** Renders a context consumer, providing the context value to the [content] builder. */
	public final inline operator fun <Value> RConsumer<Value>.invoke(noinline content: RBuilder.(context: Value) -> Unit) {
		consumer(this, content = content)
	}


	/** Renders a context provider with the given [value] and children. */
	public final inline operator fun <Value> RProvider<Value>.invoke(value: Value, content: RBuilder.() -> Unit) {
		provider(this, value = value, content = content)
	}


	/** Renders a `String` context provider. Resolves overload ambiguity with factory invoke. */
	// Resolves overload resolution ambiguity with RElementFactory<…>?.invoke(key: String?, …)
	public final inline operator fun RProvider<String>.invoke(value: String, content: RBuilder.() -> Unit) {
		provider(this, value = value, content = content)
	}


	/** Renders a nullable `String` context provider. Resolves overload ambiguity with factory invoke. */
	// Resolves overload resolution ambiguity with RElementFactory<…>?.invoke(key: String?, …)
	public final inline operator fun RProvider<String?>.invoke(value: String?, content: RBuilder.() -> Unit) {
		provider(this, value = value, content = content)
	}


	/*
	 * tag()
	 * tag(content?)
	 * tag(className?)
	 * tag(className?, content?)
	 * tag(className? = …, key? = …, ref? = …, content? = …)
	 */

	/** Renders an HTML/SVG tag with no props or children. */
	public final inline operator fun <Props : RTagProps, RefElement : Any> RTag<Props, RefElement>.invoke() {
		append(react_element(tag = this))
	}


	/** Renders an HTML/SVG tag with a [content] builder. */
	public final inline operator fun <Props : RTagProps, RefElement : Any> RTag<Props, RefElement>.invoke(
		noinline content: WithAttrs<Props>.() -> Unit,
	) {
		append(react_element(tag = this, content = content))
	}


	/** Renders an HTML/SVG tag with a [className]. */
	public final inline operator fun <Props : RTagProps, RefElement : Any> RTag<Props, RefElement>.invoke(
		className: String?,
	) {
		append(react_element(tag = this, className = className))
	}


	/** Renders an HTML/SVG tag with a [className] and [content] builder. */
	public final inline operator fun <Props : RTagProps, RefElement : Any> RTag<Props, RefElement>.invoke(
		className: String?,
		noinline content: WithAttrs<Props>.() -> Unit,
	) {
		append(react_element(tag = this, className = className, content = content))
	}


	/** Renders an HTML/SVG tag with vararg [className], optional [key], [ref], and [content]. */
	public final inline operator fun <Props : RTagProps, RefElement : Any> RTag<Props, RefElement>.invoke(
		vararg className: String?,
		key: String? = null,
		ref: RMutableRef<in RefElement?>? = null,
		noinline content: (WithAttrs<Props>.() -> Unit)? = null,
	) {
		append(react_element(tag = this, className = className, key = key, ref = ref, content = content))
	}


	/** Renders an HTML/SVG tag with a [className] array, optional [key], [ref], and [content]. */
	public final inline operator fun <Props : RTagProps, RefElement : Any> RTag<Props, RefElement>.invoke(
		className: Array<out String?>,
		key: String? = null,
		ref: RMutableRef<in RefElement?>? = null,
		unit: Unit = Unit, // https://youtrack.jetbrains.com/issue/KT-43549
		noinline content: (WithAttrs<Props>.() -> Unit)? = null,
	) {
		append(react_element(tag = this, className = className, key = key, ref = ref, content = content))
	}


	/** Appends this string as a text element. */
	public final inline operator fun String?.unaryPlus() {
		append(text = this)
	}


	/** An [RBuilder] scope that also provides access to element attributes. */
	public interface WithAttrs<out Attrs : RProps> : RBuilder {

		/** The props/attributes of the element being built. */
		public val attrs: Attrs
	}

	/** An [RBuilder] scope that also allows calling React hooks. */
	public interface WithHooks : RBuilder, RHooks
}


/** Appends an array of [elements] to the current element tree. */
public inline fun RBuilder.append(elements: Array<out RElement?>?) {
	append(React.element(elements))
}


/** Appends a [text] string as a React text element. */
public inline fun RBuilder.append(text: String?) {
	append(React.element(text))
}


/** Builds and appends a React element from the [content] builder. */
public inline fun RBuilder.element(content: RBuilder.() -> Unit) {
	append(React.element(content))
}


// Implementation moved outside RBuilder interface due to https://youtrack.jetbrains.com/issue/KT-43565
@PublishedApi
internal inline fun <Value> RBuilder.consumer(consumer: RConsumer<Value>, noinline content: RBuilder.(context: Value) -> Unit) {
	append(React.element(factory = consumer) {
		attrs.asDynamic().children = { context: Value ->
			React.element { content(context) }
		}
	})
}


// Implementation moved outside RBuilder interface due to https://youtrack.jetbrains.com/issue/KT-43565
@PublishedApi
internal inline fun <Value> RBuilder.provider(provider: RProvider<Value>, value: Value, content: RBuilder.() -> Unit) {
	append(React.element(factory = provider) {
		attrs.asDynamic().value = value
		content()
	})
}


/** Renders a custom HTML tag by [name] with a [content] builder. Workaround for KT-15708. */
// https://youtrack.jetbrains.com/issue/KT-15708
public inline fun RBuilder.tag(
	name: String,
	noinline content: RBuilder.WithAttrs<RTagProps>.() -> Unit,
) {
	tag(name)(content)
}
