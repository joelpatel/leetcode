package main

import "fmt"

func main() {
	fmt.Println(isPalindrome(" a#bA"))
	fmt.Println(isPalindrome("0P"))
	fmt.Println(isPalindrome(" "))
	fmt.Println(isPalindrome(""))
}

func isPalindrome(s string) bool {
	left := 0
	right := len(s) - 1

	for left <= right {
		if !isAlphanumeric(rune(s[left])) {
			left++
		} else if !isAlphanumeric(rune(s[right])) {
			right--
		} else {
			if uppercase(rune(s[left])) != uppercase(rune(s[right])) {
				return false
			} else {
				left++
				right--
			}
		}
	}

	return true
}

func uppercase(r rune) rune {
	if r >= 'a' && r <= 'z' {
		return r - 32
	} else {
		return r
	}
}

func isAlphanumeric(r rune) bool {
	if (r >= '0' && r <= '9') || (r >= 'a' && r <= 'z') || (r >= 'A' && r <= 'Z') {
		return true
	} else {
		return false
	}
}
