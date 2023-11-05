package main

func characterReplacement(s string, k int) int {
	charBitmap := make([]int, 26)

	var longest int
	var maxFreq int

	l := 0
	for r := 0; r < len(s); r++ {
		charIndex := rune(s[r]) - 'A'
		charBitmap[charIndex]++

		maxFreq = max(maxFreq, charBitmap[charIndex])

		if (r-l+1)-maxFreq > k {
			charBitmap[rune(s[l])-'A']--
			l++
		}

		longest = max(longest, r-l+1)
	}

	return longest
}

func max(a, b int) int {
	if a >= b {
		return a
	} else {
		return b
	}
}
