package greeter

import (
	"fmt"
	"strings"
)

type GetHourOfDayFn func() int
type GreetingLogFn func(arg string)

type greeter struct {
	GreetingLogFn  GreetingLogFn
	getHourOfDayFn GetHourOfDayFn
}

func New(getHourOfDayFn GetHourOfDayFn) greeter {
	return greeter{getHourOfDayFn: getHourOfDayFn}
}

func (me *greeter) Greet(name string) string {
	title := strings.Title(strings.TrimSpace(name))
	hourOfDay := me.getHourOfDayFn()

	greeting := getGreeting(title, hourOfDay)

	if me.GreetingLogFn != nil {
		me.GreetingLogFn(greeting)
	}

	return greeting
}

func getGreeting(title string, hourOfDay int) string {
	if hourOfDay >= 6 && hourOfDay < 12 {
		return fmt.Sprintf("Good morning %s", title)
	} else if hourOfDay >= 18 && hourOfDay < 22 {
		return fmt.Sprintf("Good evening %s", title)
	} else if hourOfDay >= 22 || hourOfDay < 6 {
		return fmt.Sprintf("Good night %s", title)
	} else {
		return fmt.Sprintf("Hello %s", title)
	}
}
