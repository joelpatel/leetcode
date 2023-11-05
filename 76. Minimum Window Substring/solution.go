package main

func minWindow(s, t string) string {
	if len(s) < len(t) {
		return ""
	}

	charCount := map[byte]int{}

	for right := 0; right < len(t); right++ {
		charCount[t[right]]++
	}

	start := 0
	minLength := len(s) + 1
	left := 0
	have := 0

	for right := 0; right < len(s); right++ {
		value, present := charCount[s[right]]
		if present {
			value--
			charCount[s[right]] = value
			if value == 0 {
				have++
			}
		}

		for have == len(charCount) {
			if right-left+1 < minLength {
				minLength = right - left + 1
				start = left
			}

			v, p := charCount[s[left]]
			if p {
				if v == 0 {
					have--
				}
				charCount[s[left]] = v + 1
			}
			left++
		}
	}

	if minLength > len(s) {
		return ""
	} else {
		return s[start : start+minLength]
	}
}
