package io.fluidsonic.react

import kotlin.test.*


class ArrayExtensionsTest {

	@Test
	fun join_concatenatesWithSeparator() {
		val result = arrayOf("a", "b", "c").join(", ")
		assertEquals("a, b, c", result)
	}

	@Test
	fun join_returnsSingleElementUnchanged() {
		val result = arrayOf("only").join(", ")
		assertEquals("only", result)
	}

	@Test
	fun join_returnsEmptyStringForEmptyArray() {
		val result = arrayOf<String>().join(", ")
		assertEquals("", result)
	}

	@Test
	fun join_usesEmptySeparator() {
		val result = arrayOf("a", "b", "c").join("")
		assertEquals("abc", result)
	}

	@Test
	fun push_addsElementToArray() {
		val array = arrayOf("a", "b")
		array.push("c")
		assertEquals(3, array.size)
		assertEquals("c", array[2])
	}

	@Test
	fun push_returnsNewLength() {
		val array = arrayOf("a", "b")
		val newLength = array.push("c")
		assertEquals(3, newLength)
	}

	@Test
	fun push_addsToEmptyArray() {
		val array = arrayOf<String>()
		val newLength = array.push("first")
		assertEquals(1, newLength)
	}

	@Test
	fun slice_returnsFullCopyWithDefaultStart() {
		val array = arrayOf(1, 2, 3)
		val sliced = array.slice()
		assertEquals(3, sliced.size)
		assertEquals(1, sliced[0])
		assertEquals(2, sliced[1])
		assertEquals(3, sliced[2])
	}

	@Test
	fun slice_returnsSubarrayFromStart() {
		val array = arrayOf(1, 2, 3, 4)
		val sliced = array.slice(2)
		assertEquals(2, sliced.size)
		assertEquals(3, sliced[0])
		assertEquals(4, sliced[1])
	}

	@Test
	fun slice_returnsSubarrayWithStartAndEnd() {
		val array = arrayOf(1, 2, 3, 4, 5)
		val sliced = array.slice(1, 3)
		assertEquals(2, sliced.size)
		assertEquals(2, sliced[0])
		assertEquals(3, sliced[1])
	}

	@Test
	fun slice_returnsEmptyArrayWhenStartEqualsLength() {
		val array = arrayOf(1, 2, 3)
		val sliced = array.slice(3)
		assertEquals(0, sliced.size)
	}
}
