package stringcalculator

import (
	"fmt"
	"regexp"
	"strconv"
	"strings"
)

type stringCalculator struct {
}

func New() *stringCalculator {
	return &stringCalculator{}
}

func (self *stringCalculator) Add(input string) int {
	strs := split(input)
	nums := parse(strs)
	assertNoNegatives(nums)
	filtered := filterOutGreaterThan1000(nums)
	return total(filtered)
}

func filterOutGreaterThan1000(nums []int) []int {
	b := nums[:0]
	for _, i := range nums {
		if i <= 1000 {
			b = append(b, i)
		}
	}
	return b
}

func assertNoNegatives(nums []int) {
	var negatives = make([]int, 0)
	for _, i := range nums {
		if i < 0 {
			negatives = append(negatives, i)
		}
	}
	if len(negatives) > 0 {
		panic(fmt.Sprintf("Negatives not allowed: %v", negatives))
	}
}

func total(ints []int) int {
	var sum = 0
	for _, i := range ints {
		sum += i
	}
	return sum
}

func split(input string) []string {
	seperators, str := getSeparatorsAndInput(input)
	return seperators.Split(str, -1)
}

func parse(strs []string) []int {
	result := make([]int, len(strs))
	for _, str := range strs {
		result = append(result, parseInt(str))
	}
	return result
}

func getSeparatorsAndInput(input string) (*regexp.Regexp, string) {
	if strings.HasPrefix(input, "//") {
		secondLineIndex := strings.IndexRune(input, '\n')
		seperatorStr := input[2:secondLineIndex]
		seperators := regexp.MustCompile(regexp.QuoteMeta(seperatorStr))
		str := input[secondLineIndex+1:]
		return seperators, str
	}
	return defaultSeperators, input
}

func parseInt(input string) int {
	i, _ := strconv.Atoi(input)
	return i
}

var defaultSeperators = regexp.MustCompile("[\n,]")
