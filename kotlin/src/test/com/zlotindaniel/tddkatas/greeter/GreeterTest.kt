package com.zlotindaniel.tddkatas.greeter

import org.assertj.core.api.Assertions.assertThat
import org.junit.Test
import java.time.LocalTime

class GreeterTest {
	@Test
	fun saysHello() {
		val greeter = Greeter { LocalTime.of(14, 0) }
		assertThat(greeter.greet("Daniel")).isEqualTo("Hello Daniel")
	}

	@Test
	fun trimsTheInput() {
		val greeter = Greeter { LocalTime.of(14, 0) }
		assertThat(greeter.greet("  Daniel \n\n\t")).isEqualTo("Hello Daniel")
	}

	@Test
	fun capitalizeName() {
		val greeter = Greeter { LocalTime.of(14, 0) }
		assertThat(greeter.greet("daniel")).isEqualTo("Hello Daniel")
	}

	@Test
	fun timeBased() {
		var time = LocalTime.of(8, 0)
		val greeter = Greeter { time }
		assertThat(greeter.greet("Daniel")).isEqualTo("Good Morning Daniel")
		time = LocalTime.of(11, 59)
		assertThat(greeter.greet("Daniel")).isEqualTo("Good Morning Daniel")
		time = LocalTime.of(12, 0)
		assertThat(greeter.greet("Daniel")).isEqualTo("Hello Daniel")
		time = LocalTime.of(17, 59)
		assertThat(greeter.greet("Daniel")).isEqualTo("Hello Daniel")
		time = LocalTime.of(18, 0)
		assertThat(greeter.greet("Daniel")).isEqualTo("Good Evening Daniel")
		time = LocalTime.of(21, 59)
		assertThat(greeter.greet("Daniel")).isEqualTo("Good Evening Daniel")
		time = LocalTime.of(22, 0)
		assertThat(greeter.greet("Daniel")).isEqualTo("Good Night Daniel")
		time = LocalTime.of(5, 59)
		assertThat(greeter.greet("Daniel")).isEqualTo("Good Night Daniel")
		time = LocalTime.of(6, 0)
		assertThat(greeter.greet("Daniel")).isEqualTo("Good Morning Daniel")
	}

	@Test
	fun logsIntoConsole() {
		var theLoggedMsg = "never called"
		val greeter = Greeter(object : Logger {
			override fun log(string: String) {
				theLoggedMsg = string
			}
		}) { LocalTime.of(14, 0) }
		assertThat(greeter.greet("Daniel")).isEqualTo("Hello Daniel")
		assertThat(theLoggedMsg).isEqualTo("Hello Daniel")
	}
}
