package io.fluidsonic.react

import kotlin.test.*


class JsObjectTest {

	@Test
	fun jsObject_createsEmptyObject() {
		val obj: dynamic = jsObject<Any>()
		val keys = js("Object.keys(obj)").unsafeCast<Array<String>>()
		assertEquals(0, keys.size)
	}

	@Test
	fun jsObject_withConfigureAllowsSettingProperties() {
		val obj: dynamic = jsObject<Any> { o ->
			o.name = "test"
			o.value = 42
		}
		assertEquals("test", obj.name)
		assertEquals(42, obj.value)
	}
}
