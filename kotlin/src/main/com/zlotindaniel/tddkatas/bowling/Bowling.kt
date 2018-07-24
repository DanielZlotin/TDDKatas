package com.zlotindaniel.tddkatas.bowling

class Bowling {
	private val rolls = IntArray(21)
	private var currentRoll = 0

	fun roll(pins: Int) {
		rolls[currentRoll++] = pins
	}

	fun score(): Int {
		var score = 0
		var i = 0
		repeat(10) {
			when {
				isSpare(i)  -> {
					score += 10 + spareBonus(i)
					i += 2
				}
				isStrike(i) -> {
					score += 10 + strikeBonus(i)
					i++
				}
				else        -> {
					score += sumOfPinsInFrame(i)
					i += 2
				}
			}
		}
		return score
	}

	private fun spareBonus(i: Int) = rolls[i + 2]

	private fun strikeBonus(i: Int) = rolls[i + 1] + rolls[i + 2]

	private fun isStrike(i: Int) = rolls[i] == 10

	private fun isSpare(i: Int) = sumOfPinsInFrame(i) == 10

	private fun sumOfPinsInFrame(i: Int) = rolls[i] + rolls[i + 1]
}
