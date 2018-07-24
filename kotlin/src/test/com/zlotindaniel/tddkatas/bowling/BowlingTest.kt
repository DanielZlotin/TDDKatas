package com.zlotindaniel.tddkatas.bowling

import org.assertj.core.api.Assertions.assertThat
import kotlin.test.*

class BowlingTest {
	private val uut = Bowling()

	@Test
	fun gutterGame() {
		repeat(20) { uut.roll(0) }
		assertThat(uut.score()).isEqualTo(0)
	}

	@Test
	fun allSinglePins() {
		repeat(20) { uut.roll(1) }
		assertThat(uut.score()).isEqualTo(20)
	}

	@Test
	fun spare() {
		rollSpare()
		uut.roll(3)
		repeat(17) { uut.roll(0) }
		assertThat(uut.score()).isEqualTo(16)
	}

	@Test
	fun strike() {
		rollStrike()
		uut.roll(3)
		uut.roll(4)
		repeat(16) { uut.roll(0) }
		assertThat(uut.score()).isEqualTo(24)
	}

	@Test
	fun perfectGame() {
		repeat(12) { uut.roll(10) }
		assertThat(uut.score()).isEqualTo(300)
	}

	private fun rollStrike() {
		uut.roll(10)
	}

	private fun rollSpare() {
		uut.roll(5)
		uut.roll(5)
	}
}
