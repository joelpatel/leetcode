package main

func hasCycle(head *ListNode) bool {
	if head == nil {
		return false
	}

	first := head
	second := head.Next

	for second != nil && second.Next != nil {
		first = first.Next
		second = second.Next.Next

		if first == second {
			return true
		}
	}

	return false
}
