package main

func lengthOfLongestSubstringMap(s string) int {
	var maxLength int

	charMap := map[byte]int{}

	for i, j := 0, 0; j < len(s); j++ {
		if index, ok := charMap[s[j]]; ok && index >= i {
			// char repeated in [i:j] (inclusive)
			i = index + 1
		}
		maxLength = max(maxLength, j-i+1)
		charMap[s[j]] = j
	}

	return maxLength
}
