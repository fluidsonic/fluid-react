package io.fluidsonic.react

import kotlin.test.*


class REffectBuilderTest {

	@Test
	fun cleanup_registersCallback() {
		val cleanups = arrayOf<() -> Unit>()
		val builder = cleanups.unsafeCast<REffectBuilder>()
		var called = false
		builder.cleanup { called = true }
		assertEquals(1, cleanups.size)
		cleanups[0]()
		assertTrue(called)
	}

	@Test
	fun cleanup_registersMultipleCallbacks() {
		val cleanups = arrayOf<() -> Unit>()
		val builder = cleanups.unsafeCast<REffectBuilder>()
		builder.cleanup { }
		builder.cleanup { }
		builder.cleanup { }
		assertEquals(3, cleanups.size)
	}

	@Test
	fun buildEffect_returnsCleanupFunctionWhenCleanupsRegistered() {
		val effectFn = buildEffect {
			cleanup { }
		}
		val cleanup = effectFn()
		assertNotNull(cleanup)
	}

	@Test
	fun buildEffect_executesAllCleanupsOnCleanup() {
		val calls = mutableListOf<Int>()
		val effectFn = buildEffect {
			cleanup { calls.add(1) }
			cleanup { calls.add(2) }
		}
		val cleanup = effectFn()
		assertNotNull(cleanup)
		cleanup()
		assertEquals(listOf(1, 2), calls)
	}
}
