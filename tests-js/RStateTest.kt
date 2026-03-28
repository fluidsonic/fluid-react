package io.fluidsonic.react

import kotlin.test.*


class RStateTest {

	@Test
	fun component1_returnsCurrentValue() {
		val state = RState("hello") {}
		val (value) = state
		assertEquals("hello", value)
	}

	@Test
	fun component2_returnsSetterFunction() {
		var captured: String? = null
		val state = RState("initial") { captured = it }
		val (_, setter) = state
		setter("updated")
		assertEquals("updated", captured)
	}

	@Test
	fun get_returnsCurrentValue() {
		val state = RState(42) {}
		assertEquals(42, state.get())
	}

	@Test
	fun rState_factoryCreatesWorkingState() {
		var setCalled = false
		val state = RState("value") { setCalled = true }
		assertEquals("value", state.component1())
		state.component2()("new")
		assertTrue(setCalled)
	}
}
