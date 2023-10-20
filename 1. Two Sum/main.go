package main

import "fmt"

func main() {
	fmt.Println(twoSum([]int{3, 3}, 6))
}

func twoSum(nums []int, target int) []int {
	// map[expected]index
	m := make(map[int]int)

	for i := 0; i < len(nums); i++ {
		if j, ok := m[nums[i]]; ok {
			return []int{j, i}
		}
		m[target-nums[i]] = i
	}

	return []int{}
}
