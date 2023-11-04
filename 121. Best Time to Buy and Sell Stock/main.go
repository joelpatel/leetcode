package main

import "fmt"

func main() {
	fmt.Println(maxProfit([]int{7, 1, 5, 3, 6, 4}))
}

func maxProfit(prices []int) int {
	if len(prices) == 1 {
		return 0
	}

	maxProfit := 0

	for i, j := 0, 1; i <= len(prices)-2 && j <= len(prices)-1; {
		if prices[i] > prices[j] {
			i = j
		} else {
			maxProfit = max(maxProfit, prices[j]-prices[i])
		}
		j++
	}

	return maxProfit
}

func max(i, j int) int {
	if i >= j {
		return i
	} else {
		return j
	}
}
