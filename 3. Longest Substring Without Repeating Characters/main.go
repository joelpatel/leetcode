package main

import "fmt"

func main() {
	fmt.Println(lengthOfLongestSubstring("abcabcbb"))
}

func lengthOfLongestSubstring(s string) int {
	var maxLength int

	charSet := map[byte]bool{}

	for i, j := 0, 0; j < len(s); j++ {
		for charSet[s[j]] {
			delete(charSet, s[i])
			i++
		}
		charSet[s[j]] = true
		maxLength = max(maxLength, j-i+1)
	}

	return maxLength
}

func max(a, b int) int {
	if a >= b {
		return a
	} else {
		return b
	}
}
