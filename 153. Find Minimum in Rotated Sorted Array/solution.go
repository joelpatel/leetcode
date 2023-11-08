package main

func findMin(nums []int) int {
	if len(nums) == 0 || nums[0] < nums[len(nums)-1] {
		return nums[0]
	}

	left := 0
	right := len(nums) - 1
	var mid int

	for left <= right {
		if nums[left] <= nums[right] {
			return nums[left]
		}

		mid = (left + right) / 2
		if nums[left] <= nums[mid] {
			left = mid + 1
		} else {
			right = mid
		}
	}

	return 0
}
