package main

import "fmt"

func main() {
	fmt.Println(isAnagram("nil", "nil"))
	fmt.Println(isAnagram("nil", "il"))
	fmt.Println(isAnagram("nil", "ail"))
	fmt.Println(isAnagram("nil", "iln"))
}

func isAnagram(s string, t string) bool {
	if len(s) != len(t) {
		return false
	}

	runeArray := [26]int{0}

	for _, r := range s {
		runeArray[r-'a']++
	}

	for _, r := range t {
		runeArray[r-'a']--
	}

	for _, r := range runeArray {
		if r != 0 {
			return false
		}
	}

	return true
}

func isAnagram2(s string, t string) bool {
	if len(s) != len(t) {
		return false
	}

	chars := [26]int{}

	for i := 0; i < len(s); i++ {
		chars[s[i]-'a']++
		chars[t[i]-'a']--
	}

	for i := 0; i < 26; i++ {
		if chars[i] != 0 {
			return false
		}
	}

	return true
}

func isASCIIAnagram(s, t string) bool {
	if len(s) != len(t) {
		return false
	}

	runeCountMap := make(map[byte]int)

	for i := 0; i < len(s); i++ {
		runeCountMap[s[i]]++
		runeCountMap[t[i]]--
	}

	for _, v := range runeCountMap {
		if v != 0 {
			return false
		}
	}

	return true
}
