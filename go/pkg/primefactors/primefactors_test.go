package primefactors_test

import (
	"fmt"
	"testing"

	"github.com/stretchr/testify/assert"

	"github.com/DanielZlotin/TDDKatas/go/pkg/primefactors"
)

var dataPoints = []struct {
	n        int
	expected []int
}{
	{1, []int{}},
	{2, []int{2}},
	{3, []int{3}},
	{4, []int{2, 2}},
	{5, []int{5}},
	{6, []int{2, 3}},
	{7, []int{7}},
	{8, []int{2, 2, 2}},
	{9, []int{3, 3}},
	{2 * 2 * 3 * 5 * 7 * 11, []int{2, 2, 3, 5, 7, 11}},
}

func TestGeneratePrimes(t *testing.T) {
	for _, p := range dataPoints {
		t.Run(fmt.Sprintf("GeneratePrimes:%d", p.n), func(tt *testing.T) {
			result := primefactors.GeneratePrimes(p.n)
			assert.ElementsMatch(tt, p.expected, result)
		})
	}
}
