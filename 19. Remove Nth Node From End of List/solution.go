package main

func removeNthFromEnd(head *ListNode, n int) *ListNode {
	start := head

	count := 0

	for count < n && head != nil {
		head = head.Next
		count++
	}

	var prev *ListNode
	second := start
	for head != nil {
		prev = second
		head = head.Next
		second = second.Next
	}

	if prev != nil {
		prev.Next = second.Next
		second.Next = nil
	} else {
		start = second.Next
		second.Next = nil
	}

	return start
}
