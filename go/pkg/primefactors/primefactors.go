package primefactors

func GeneratePrimes(n int) []int {
	var result []int

	for candidate := 2; n >= candidate; candidate++ {
		for n%candidate == 0 {
			n /= candidate
			result = append(result, candidate)
		}
	}

	return result
}
