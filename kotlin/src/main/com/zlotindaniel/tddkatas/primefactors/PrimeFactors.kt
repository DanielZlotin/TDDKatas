package com.zlotindaniel.tddkatas.primefactors

class PrimeFactors private constructor() {
	companion object {
		fun of(n: Int): List<Int> {
			val primes = mutableListOf<Int>()
			var remainder = n
			for (divisor in 2..remainder) {
				while (remainder % divisor == 0) {
					primes.add(divisor)
					remainder /= divisor
				}
			}
			return primes
		}
	}
}
