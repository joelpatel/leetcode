package main

import (
	"fmt"
)

func main() {
	fmt.Println(groupAnagrams([]string{"ab", "ba"}))
}

func groupAnagrams(strs []string) [][]string {
	bitmapStringsMap := make(map[[26]int][]string)

	for _, s := range strs {
		bitmap := [26]int{}
		for i := 0; i < len(s); i++ {
			bitmap[s[i]-'a']++
		}

		if stringList, ok := bitmapStringsMap[bitmap]; ok {
			bitmapStringsMap[bitmap] = append(stringList, s)
		} else {
			bitmapStringsMap[bitmap] = []string{s}
		}
	}

	var result [][]string
	for _, v := range bitmapStringsMap {
		result = append(result, v)
	}

	return result
}
