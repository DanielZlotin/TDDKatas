package com.zlotindaniel.tddkatas.stringcalculator


class StringCalculator {

    companion object {
        private val defaultDelimiter = "[,\n]".toRegex()
    }

    fun add(input: String): Int {
        if (input.isEmpty()) return 0

        return input.parseInts()
                .assertNoNegatives()
                .filter { it <= 1000 }
                .sum()
    }

    private fun String.parseInts(): List<Int> {
        val (delimiter, str) = splitDelimiterAndStr()
        return str.split(delimiter)
                .map { it.toInt() }
    }

    private fun String.splitDelimiterAndStr() = if (startsWith("//")) {
        parseCustomDelimiter()
    } else {
        defaultDelimiter to this
    }

    private fun List<Int>.assertNoNegatives(): List<Int> {
        val negatives = filter { it < 0 }
        if (negatives.isNotEmpty()) {
            throw RuntimeException("Negatives not allowed: ${negatives.joinToString(",")}")
        }
        return this
    }

    private fun String.parseCustomDelimiter(): Pair<Regex, String> {
        val i = indexOf('\n')
        val delimiter = Regex.escape(substring(2, i))
        val str = substring(i + 1)
        return delimiter.toRegex() to str
    }
}
