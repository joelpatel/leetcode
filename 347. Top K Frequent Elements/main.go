package main

import "fmt"

func main() {
	fmt.Println(topKFrequent([]int{1, 2}, 2))
}

/*
Measure count of each element.
Fill a bucket of list based on the count of each element.
Go over the bucket in descending order till you have k elements poped.
*/
func topKFrequent(nums []int, k int) []int {
	countMap := make(map[int]int)

	for _, el := range nums {
		countMap[el]++
	}

	buckets := make([][]int, len(nums)+1)
	for key, value := range countMap {
		buckets[value] = append(buckets[value], key)
	}

	var topK []int
	for i := len(buckets) - 1; i >= 0; i-- {
		for j := 0; j < len(buckets[i]); j++ {
			if k <= 0 {
				return topK
			}
			topK = append(topK, buckets[i][j])
			k--
		}
	}

	return topK
}
