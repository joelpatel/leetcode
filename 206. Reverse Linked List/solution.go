package main

func reverseList(head *ListNode) *ListNode {
	return recursive(nil, head)
}

func iterative(current *ListNode) *ListNode {
	var prev, next *ListNode

	for current != nil {
		next = current.Next
		current.Next = prev
		prev = current
		current = next
	}

	return prev
}

func recursive(prev, current *ListNode) *ListNode {
	if current == nil {
		return current
	} else if current.Next == nil {
		current.Next = prev
		return current
	}

	next := current.Next
	current.Next = prev

	return recursive(current, next)
}
