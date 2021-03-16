@file:JsModule("react")

package io.fluidsonic.react.external

import io.fluidsonic.react.*
import kotlin.js.Promise


@JsName("createContext")
@PublishedApi
internal external fun <Value> external_createContext(
	defaultValue: Value,
): RContext<Value>


@JsName("createElement")
@PublishedApi
internal external fun <Props : RProps> external_createElement(
	factory: RElementFactory<Props>,
	props: Props,
	vararg children: RElement?,
): RElement?


@JsName("createRef")
@PublishedApi
internal external fun <Value> external_createRef(): RMutableRef<Value>


@JsName("lazy")
@PublishedApi
internal external fun <Props : RProps> external_lazy(
	factory: () -> Promise<RElementFactoryModule<Props>>,
): RElementFactory<Props>


@JsName("memo")
@PublishedApi
internal external fun <Props : RProps> external_memo(
	factory: RElementFactory<Props>,
	propsAreEqual: (oldProps: Props, newProps: Props) -> Boolean = definedExternally,
): RElementFactory<Props>


@JsName("useContext")
@PublishedApi
internal external fun <Value> external_useContext(
	context: RContext<Value>,
): Value


@JsName("useDebugValue")
@PublishedApi
internal external fun external_useDebugValue(
	value: Any?,
)


@JsName("useEffect")
@PublishedApi
internal external fun external_useEffect(
	effect: () -> (() -> Unit)?,
	dependencies: Array<out Any?>? = definedExternally,
)


@JsName("useRef")
@PublishedApi
internal external fun <Value> external_useRef(
	initialValue: Value,
): RMutableRef<Value>


@JsName("useLayoutEffect")
@PublishedApi
internal external fun external_useLayoutEffect(
	effect: () -> (() -> Unit)?,
	dependencies: Array<out Any?>? = definedExternally,
)


@JsName("useState")
@PublishedApi
internal external fun <Value> external_useState(
	initialValue: Value,
): RState<Value>


@JsName("useState")
@PublishedApi
internal external fun <Value> external_useState(
	initialValue: () -> Value,
): RState<Value>


@JsName("Children")
@PublishedApi
@Suppress("ClassName")
internal external object External_Children {

	fun count(children: RChildren?): Int
	fun forEach(children: RChildren?, handler: (RElement?) -> Unit)
	fun <T> map(children: RChildren?, handler: (RElement?) -> T): Array<out T>?
	fun only(children: RChildren?): RElement
	fun toArray(children: RChildren?): Array<out RElement?>
}


@JsName("Fragment")
@PublishedApi
internal external val External_Fragment: RElementFactory<RProps.WithChildren>

@JsName("StrictMode")
@PublishedApi
internal external val External_StrictMode: RElementFactory<RProps.WithChildren>

@JsName("Suspense")
@PublishedApi
internal external val External_Suspense: RElementFactory<RSuspenseProps>
