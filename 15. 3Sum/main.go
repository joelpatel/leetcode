package main

import (
	"fmt"
	"slices"
)

func main() {
	fmt.Println(threeSum([]int{-2, 0, 1, 1, 2}))
}

func threeSum(nums []int) [][]int {
	var result [][]int

	slices.Sort(nums)

	for i := 0; i < len(nums)-2; i++ {
		if i > 0 && nums[i-1] == nums[i] {
			continue
		}

		left := i + 1
		right := len(nums) - 1

		for left < right {
			sum := nums[i] + nums[left] + nums[right]
			if sum > 0 {
				right--
			} else if sum < 0 {
				left++
			} else {
				result = append(result, []int{nums[i], nums[left], nums[right]})
				left++
				right--

				for left <= len(nums)-1 && nums[left] == nums[left-1] {
					left++
				}

				for right >= i+1 && nums[right] == nums[right+1] {
					right--
				}
			}
		}
	}

	return result
}
