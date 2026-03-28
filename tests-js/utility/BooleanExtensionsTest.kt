package io.fluidsonic.react

import kotlin.test.*


class BooleanExtensionsTest {

	@Test
	fun thenTake_returnsValueWhenTrue() {
		val result = true.thenTake { "hello" }
		assertEquals("hello", result)
	}

	@Test
	fun thenTake_returnsNullWhenFalse() {
		val result = false.thenTake { "hello" }
		assertNull(result)
	}

	@Test
	fun thenTake_doesNotEvaluateBlockWhenFalse() {
		var evaluated = false
		false.thenTake { evaluated = true }
		assertFalse(evaluated)
	}

	@Test
	fun thenTake_evaluatesBlockWhenTrue() {
		var evaluated = false
		true.thenTake { evaluated = true }
		assertTrue(evaluated)
	}
}
