package stringcalculator_test

import (
	"fmt"
	"testing"

	"github.com/stretchr/testify/assert"

	"github.com/DanielZlotin/TDDKatas/go/pkg/stringcalculator"
)

var testDataPoints = []struct {
	input    string
	expected int
}{
	{"", 0},
	{"1", 1},
	{"2", 2},
	{"1,2", 3},
	{"10,20", 30},
	{"1\n2", 3},
	{"1\n2,3\n4", 10},
	{"1,1001,2,1000", 1003},
	{"//#\n100#12", 112},
	{"//###\n123###456", 579},
	{"//\\\n1\\2", 3},
}

func TestStringCalculator(t *testing.T) {
	for n, p := range testDataPoints {
		t.Run(fmt.Sprintf("StringCalculator:%d", n), func(tt *testing.T) {
			uut := stringcalculator.New()
			result := uut.Add(p.input)
			assert.EqualValues(tt, p.expected, result)
		})
	}
}

func TestNegativesThrow(t *testing.T) {
	uut := stringcalculator.New()
	assert.PanicsWithValue(t, "Negatives not allowed: [-1 -3]", func() {
		uut.Add("-1,2,-3")
	})
}
