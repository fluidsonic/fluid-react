@file:Suppress(
	"EXTENSION_FUNCTION_IN_EXTERNAL_DECLARATION",
	"INLINE_EXTERNAL_DECLARATION",
	"NON_ABSTRACT_MEMBER_OF_EXTERNAL_INTERFACE",
	"NOTHING_TO_INLINE",
	"WRONG_BODY_OF_EXTERNAL_DECLARATION",
	"WRONG_DEFAULT_VALUE_FOR_EXTERNAL_FUN_PARAMETER",
	"WRONG_EXTERNAL_DECLARATION",
	"WRONG_MODIFIER_CONTAINING_DECLARATION",
)

package io.fluidsonic.react

import kotlin.internal.*
import kotlin.reflect.*


@RDsl
public external interface RBuilder : RTags {

	@RDsl
	public final inline operator fun RElement?.invoke() {
		append(this)
	}


	@RDsl
	public final inline operator fun Array<out RElement?>?.invoke() {
		append(this)
	}


	@RDsl
	public final inline operator fun RComponent<Unit>.invoke(key: String? = null) {
		append(react.element(component = this, key = key))
	}


	@RDsl
	public final inline operator fun RComponent.WithChildren<Unit>.invoke(key: String? = null, content: RBuilder.() -> Unit) {
		append(react.element(component = this, key = key, content = content))
	}


	@RDsl
	public final inline operator fun <Props : Any> RComponent<Props>.invoke(props: Props, key: String? = null) {
		append(react.element(component = this, props = props, key = key))
	}


	@RDsl
	public final inline operator fun <Props : Any> RComponent.WithChildren<Props>.invoke(props: Props, key: String? = null, content: RBuilder.() -> Unit) {
		append(react.element(component = this, props = props, key = key, content = content))
	}


	@RDsl
	public final inline operator fun KClass<out RElementFactoryClass<in RProps.WithChildren>>.invoke(key: String? = null, ref: RMutableRef<*>? = null) {
		append(react.element(factoryClass = this, key = key, ref = ref))
	}


	@RDsl
	public final inline operator fun KClass<out RElementFactoryClass<RProps.WithChildren>>.invoke(
		key: String? = null,
		ref: RMutableRef<*>? = null,
		content: RBuilder.() -> Unit,
	) {
		append(react.element(factoryClass = this, content = content, key = key, ref = ref))
	}


	@RDsl
	public final inline operator fun <Props : RProps> KClass<out RElementFactoryClass<Props>>.invoke(
		key: String? = null,
		ref: RMutableRef<*>? = null,
		content: WithAttrs<Props>.() -> Unit,
	) {
		append(react.element(factoryClass = this, content = content, key = key, ref = ref))
	}


	@RDsl
	public final inline operator fun RElementFactory<in RProps.WithChildren>.invoke(key: String? = null, ref: RMutableRef<*>? = null) {
		append(react.element(factory = this, key = key, ref = ref))
	}


	@RDsl
	public final inline operator fun RElementFactory<RProps.WithChildren>.invoke(
		key: String? = null,
		ref: RMutableRef<*>? = null,
		content: RBuilder.() -> Unit,
	) {
		append(react.element(factory = this, key = key, ref = ref, content = content))
	}


	// TODO Builder shouldn't allow adding children when Props is not subtype of RProps.WithChildren
	@RDsl
	public final inline operator fun <Props : RProps> RElementFactory<Props>.invoke(
		key: String? = null,
		ref: RMutableRef<*>? = null,
		content: WithAttrs<Props>.() -> Unit,
	) {
		append(react.element(factory = this, key = key, ref = ref, content = content))
	}


	@RDsl
	public final inline operator fun <Props : RProps> RElementFactory<Props>.invoke(
		props: Props,
		key: String? = null,
		ref: RMutableRef<*>? = null,
	) {
		append(react.element(factory = this, props = props, key = key, ref = ref))
	}


	@RDsl
	public final inline operator fun <Props : RProps.WithChildren> RElementFactory<Props>.invoke(
		props: Props,
		key: String? = null,
		ref: RMutableRef<*>? = null,
		content: RBuilder.() -> Unit,
	) {
		append(react.element(factory = this, key = key, ref = ref, content = content))
	}


	// Workaround for lack of https://youtrack.jetbrains.com/issue/KT-10468
	@RDsl
	public final inline operator fun RFunction.invoke() {
		this@RBuilder.invoke()
	}


	// Workaround for lack of https://youtrack.jetbrains.com/issue/KT-10468
	@RDsl
	public final inline operator fun <P1> RFunction1<P1>.invoke(p1: P1) {
		this@RBuilder.invoke(p1)
	}


	@RDsl
	public final inline operator fun <Value> RConsumer<Value>.invoke(noinline content: RBuilder.(context: Value) -> Unit) {
		consumer(this, content = content)
	}


	@RDsl
	public final inline operator fun <Value> RProvider<Value>.invoke(value: Value, content: RBuilder.() -> Unit) {
		provider(this, value = value, content = content)
	}


	// Resolves overload resolution ambiguity with RElementFactory<…>?.invoke(key: String?, …)
	@RDsl
	public final inline operator fun RProvider<String>.invoke(value: String, content: RBuilder.() -> Unit) {
		provider(this, value = value, content = content)
	}


	// Resolves overload resolution ambiguity with RElementFactory<…>?.invoke(key: String?, …)
	@RDsl
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

	@RDsl
	public final inline operator fun <Props : RTagProps, RefElement : Any> RTag<Props, RefElement>.invoke() {
		append(react_element(tag = this))
	}


	@RDsl
	public final inline operator fun <Props : RTagProps, RefElement : Any> RTag<Props, RefElement>.invoke(
		noinline content: WithAttrs<Props>.() -> Unit,
	) {
		append(react_element(tag = this, content = content))
	}


	@RDsl
	public final inline operator fun <Props : RTagProps, RefElement : Any> RTag<Props, RefElement>.invoke(
		className: String?,
	) {
		append(react_element(tag = this, className = className))
	}


	@RDsl
	public final inline operator fun <Props : RTagProps, RefElement : Any> RTag<Props, RefElement>.invoke(
		className: String?,
		noinline content: WithAttrs<Props>.() -> Unit,
	) {
		append(react_element(tag = this, className = className, content = content))
	}


	@RDsl
	public final inline operator fun <Props : RTagProps, RefElement : Any> RTag<Props, RefElement>.invoke(
		vararg className: String?,
		key: String? = null,
		ref: RMutableRef<in RefElement?>? = null,
		noinline content: (WithAttrs<Props>.() -> Unit)? = null,
	) {
		append(react_element(tag = this, className = className, key = key, ref = ref, content = content))
	}


	@RDsl
	public final inline operator fun <Props : RTagProps, RefElement : Any> RTag<Props, RefElement>.invoke(
		className: Array<out String?>,
		key: String? = null,
		ref: RMutableRef<in RefElement?>? = null,
		unit: Unit = Unit, // https://youtrack.jetbrains.com/issue/KT-43549
		noinline content: (WithAttrs<Props>.() -> Unit)? = null,
	) {
		append(react_element(tag = this, className = className, key = key, ref = ref, content = content))
	}


	@RDsl
	public final inline operator fun String?.unaryPlus() {
		append(text = this)
	}


	public interface WithAttrs<out Attrs : RProps> : RBuilder

	public interface WithHooks : RBuilder, RHooks
}


@PublishedApi
internal inline val RBuilder.data: Array<Any?>
	get() = unsafeCast<Array<Any?>>()


public inline val <Attrs : RProps> RBuilder.WithAttrs<Attrs>.attrs: Attrs
	get() = data[0].unsafeCast<Attrs>()


@RDsl
public inline fun RBuilder.append(element: RElement?) {
	data.push(element)
}


@RDsl
public inline fun RBuilder.append(elements: Array<out RElement?>?) {
	append(react.element(elements))
}


@RDsl
public inline fun RBuilder.append(text: String?) {
	append(react.element(text))
}


@RDsl
public inline fun RBuilder.element(content: RBuilder.() -> Unit) {
	append(react.element(content))
}


// Implementation moved outside of RBuilder interface due to https://youtrack.jetbrains.com/issue/KT-43565
@PublishedApi
internal inline fun <Value> RBuilder.consumer(consumer: RConsumer<Value>, noinline content: RBuilder.(context: Value) -> Unit) {
	append(react.element(factory = consumer) {
		attrs.asDynamic().children = { context: Value ->
			react.element { content(context) }
		}
	})
}


// Implementation moved outside of RBuilder interface due to https://youtrack.jetbrains.com/issue/KT-43565
@PublishedApi
internal inline fun <Value> RBuilder.provider(provider: RProvider<Value>, value: Value, content: RBuilder.() -> Unit) {
	append(react.element(factory = provider) {
		attrs.asDynamic().value = value
		content()
	})
}


// https://youtrack.jetbrains.com/issue/KT-15708
@RDsl
public inline fun RBuilder.tag(
	name: String,
	noinline content: RBuilder.WithAttrs<RTagProps>.() -> Unit,
) {
	tag(name)(content)
}
