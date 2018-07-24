package com.zlotindaniel.tddkatas.stringcalculator

import org.assertj.core.api.Assertions.assertThat
import kotlin.test.*

class StringCalculatorTest {
	private val uut = StringCalculator()

	@Test
	fun emptyStringIsZero() {
		assertThat(uut.add("")).isEqualTo(0)
	}

	@Test
	fun singleNumber() {
		assertThat(uut.add("1")).isEqualTo(1)
		assertThat(uut.add("2")).isEqualTo(2)
	}

	@Test
	fun twoNumbersCommaDelimited() {
		assertThat(uut.add("1,2")).isEqualTo(3)
		assertThat(uut.add("10,20")).isEqualTo(30)
	}

	@Test
	fun newlineDelimited() {
		assertThat(uut.add("1\n2")).isEqualTo(3)
	}

	@Test
	fun delimitedEitherWay() {
		assertThat(uut.add("1\n2,3\n4")).isEqualTo(10)
	}

	@Test
	fun negativesThrowException() {
		val exception = assertFailsWith<RuntimeException> {
			uut.add("-1,2,-3")
		}
		assertThat(exception.message).isEqualTo("Negatives not allowed: -1,-3")
	}

	@Test
	fun ignoreGreaterThan1000() {
		assertThat(uut.add("1,1001,2,1000")).isEqualTo(1003)
	}

	@Test
	fun customCharDelimiterOnFirstLine() {
		assertThat(uut.add("//#\n1#2")).isEqualTo(3)
	}

	@Test
	fun customMultiCharDelimiterOnFirstLine() {
		assertThat(uut.add("//xxx\n1xxx2")).isEqualTo(3)
		assertThat(uut.add("//...\n1...2")).isEqualTo(3)
	}
}
