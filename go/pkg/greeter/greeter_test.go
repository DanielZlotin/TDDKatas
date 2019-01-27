package greeter_test

import (
	"testing"

	"github.com/stretchr/testify/assert"

	"github.com/DanielZlotin/TDDKatas/go/pkg/greeter"
)

func TestGreeterGreets(t *testing.T) {
	uut := greeter.New(func() int { return 14 })
	result := uut.Greet("Bob")
	assert.EqualValues(t, "Hello Bob", result)
}

func TestTrimsTheInput(t *testing.T) {
	uut := greeter.New(func() int { return 14 })
	result := uut.Greet("\tBob \n")
	assert.EqualValues(t, "Hello Bob", result)
}

func TestCapitalize(t *testing.T) {
	uut := greeter.New(func() int { return 14 })
	result := uut.Greet("bob")
	assert.EqualValues(t, "Hello Bob", result)
}

func TestGoodMorning(t *testing.T) {
	uut := greeter.New(func() int { return 8 })
	result := uut.Greet("Bob")
	assert.EqualValues(t, "Good morning Bob", result)
}

func TestGoodEvening(t *testing.T) {
	uut := greeter.New(func() int { return 18 })
	result := uut.Greet("Bob")
	assert.EqualValues(t, "Good evening Bob", result)
}

func TestGoodNight(t *testing.T) {
	uut := greeter.New(func() int { return 22 })
	result := uut.Greet("Bob")
	assert.EqualValues(t, "Good night Bob", result)
}

func TestLogs(t *testing.T) {
	uut := greeter.New(func() int { return 16 })

	var calledWith = make([]string, 0)
	uut.GreetingLogFn = func(arg string) {
		calledWith = append(calledWith, arg)
	}
	result := uut.Greet("Bob")
	assert.EqualValues(t, "Hello Bob", result)
	assert.ElementsMatch(t, calledWith, []string{"Hello Bob"})
}
