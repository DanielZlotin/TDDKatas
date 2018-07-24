package com.zlotindaniel.tddkatas.stringcalculator

private val DEFAULT_DELIMITER = Regex("[,\n]")

class StringCalculator {

	fun add(input: String): Int {
		if (input.isEmpty()) return 0
		val numbers = parse(input)
		assertNoNegatives(numbers)
		return numbers.filter { it <= 1000 }
				.reduce { acc, i -> acc + i }
	}

	private fun assertNoNegatives(numbers: List<Int>) {
		val negatives = numbers.filter { it < 0 }
		if (negatives.isNotEmpty()) {
			throw RuntimeException("Negatives not allowed: ${negatives.joinToString(",")}")
		}
	}

	private fun parse(input: String): List<Int> {
		val (delimiter, str) = delimiterAndStr(input)
		return str.split(delimiter)
				.map(Integer::parseInt)
	}

	private fun delimiterAndStr(input: String): Pair<Regex, String> {
		return if (input.startsWith("//")) {
			val i = input.indexOf('\n')
			val delimiter = Regex.escape(input.substring(2, i))
			val str = input.substring(i + 1)
			Pair(Regex(delimiter), str)
		} else {
			Pair(DEFAULT_DELIMITER, input)
		}
	}
}
