package main

import "fmt"

func main() {
	fmt.Println(productExceptSelf([]int{-1, 1, 0, -3, 3}))
}

func productExceptSelf(nums []int) []int {
	result := make([]int, len(nums))
	multiplier := 1

	result[0] = multiplier
	for i := 1; i < len(nums); i++ {
		multiplier *= nums[i-1]
		result[i] = multiplier
	}

	multiplier = 1
	for i := len(nums) - 2; i >= 0; i-- {
		multiplier *= nums[i+1]
		result[i] *= multiplier
	}

	return result
}
