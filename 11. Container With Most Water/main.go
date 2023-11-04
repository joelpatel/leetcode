package main

import (
	"fmt"
)

func main() {
	fmt.Println(maxArea([]int{1, 8, 6, 2, 5, 4, 8, 3, 7}))
}

func maxArea(height []int) int {
	var maxArea int
	left := 0
	right := len(height) - 1

	for left < right {
		leftY := height[left]
		rightY := height[right]

		maxArea = max(maxArea, calculateArea(left, right, leftY, rightY))
		if height[left] < height[right] {
			left++
			for left < right && height[left] < leftY {
				left++
			}
		} else {
			right--
			for left < right && height[right] < rightY {
				right--
			}
		}
	}

	return maxArea
}

func calculateArea(x1, x2, y1, y2 int) int {
	return (x2 - x1) * min(y1, y2)
}

func max(a, b int) int {
	if a >= b {
		return a
	} else {
		return b
	}
}

func min(a, b int) int {
	if a <= b {
		return a
	} else {
		return b
	}
}
