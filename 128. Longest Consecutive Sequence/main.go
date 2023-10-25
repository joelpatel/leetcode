package main

import (
	"fmt"
)

func main() {
	fmt.Println(longestConsecutive([]int{100, 4, 200, 1, 3, 2}))
}

func longestConsecutive(nums []int) int {
	longest := 0
	m := make(map[int]bool)

	for _, num := range nums {
		m[num] = true
	}

	for key := range m {
		if _, ok := m[key-1]; !ok {
			count := 0

			ok := true
			for ok {
				key++
				_, ok = m[key]
				count++
			}
			longest = max(count, longest)
		}

		if longest > len(nums)/2 {
			break
		}
	}

	return longest
}
