package com.zlotindaniel.tddkatas

import org.assertj.core.api.Assertions.assertThat
import org.junit.Test

class EnvTest {
	@Test
	fun itJustWorks() {
		assertThat(1 + 1).isPositive()
				.isNotZero()
				.isNotNegative()
				.isNotNull()
				.isEqualTo(2)
	}
}
