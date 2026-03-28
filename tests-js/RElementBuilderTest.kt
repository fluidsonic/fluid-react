package io.fluidsonic.react

import kotlin.test.*


class RElementBuilderTest {

	@Test
	fun append_addsNonNullElement() {
		val builder = RElementBuilder()
		val element = jsObject<RElement>()
		builder.append(element)
		assertEquals(1, builder.elements.size)
	}

	@Test
	fun append_ignoresNullElement() {
		val builder = RElementBuilder()
		builder.append(null)
		assertEquals(0, builder.elements.size)
	}

	@Test
	fun append_addsMultipleElements() {
		val builder = RElementBuilder()
		builder.append(jsObject<RElement>())
		builder.append(jsObject<RElement>())
		builder.append(jsObject<RElement>())
		assertEquals(3, builder.elements.size)
	}
}
