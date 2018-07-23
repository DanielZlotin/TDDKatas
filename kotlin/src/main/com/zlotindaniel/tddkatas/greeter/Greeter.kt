package com.zlotindaniel.tddkatas.greeter

import java.time.LocalTime

interface Logger {
	fun log(string: String)
}

class Greeter(private val logger: Logger? = null,
              private val getTime: () -> LocalTime) {

	fun greet(name: String): String {
		val txt = name.trim().capitalize()

		val result = when (getTime().hour) {
			in 6..11  -> "Good Morning $txt"
			in 12..17 -> "Hello $txt"
			in 18..21 -> "Good Evening $txt"
			else      -> "Good Night $txt"
		}

		logger?.log(result)
		return result
	}
}
