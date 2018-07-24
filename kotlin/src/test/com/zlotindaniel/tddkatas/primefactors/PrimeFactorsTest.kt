package com.zlotindaniel.tddkatas.primefactors

import org.assertj.core.api.Assertions.assertThat
import kotlin.test.Test

class PrimeFactorsTest {
	@Test
	fun generatePrimes() {
		assertThat(PrimeFactors.of(1)).isEmpty()
		assertThat(PrimeFactors.of(2)).containsExactly(2)
		assertThat(PrimeFactors.of(3)).containsExactly(3)
		assertThat(PrimeFactors.of(4)).containsExactly(2, 2)
		assertThat(PrimeFactors.of(5)).containsExactly(5)
		assertThat(PrimeFactors.of(6)).containsExactly(2, 3)
		assertThat(PrimeFactors.of(7)).containsExactly(7)
		assertThat(PrimeFactors.of(8)).containsExactly(2, 2, 2)
		assertThat(PrimeFactors.of(9)).containsExactly(3, 3)
		assertThat(PrimeFactors.of(4620)).containsExactly(2, 2, 3, 5, 7, 11)
	}
}
