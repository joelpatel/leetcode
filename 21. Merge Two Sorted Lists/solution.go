package main

func mergeTwoLists(l1, l2 *ListNode) *ListNode {
	var head, current *ListNode
	if l1 == nil {
		return l2
	} else if l2 == nil {
		return l1
	} else {
		if l1.Val <= l2.Val {
			head = l1
			l1 = l1.Next
		} else {
			head = l2
			l2 = l2.Next
		}
		current = head
	}

	// merging 2
	for l1 != nil && l2 != nil {
		if l1.Val <= l2.Val {
			current.Next = l1
			l1 = l1.Next
		} else {
			current.Next = l2
			l2 = l2.Next
		}
		current = current.Next
	}

	// mergin remaining - l1
	for l1 != nil {
		current.Next = l1
		l1 = l1.Next
		current = current.Next
	}

	// mergin remaining - l2
	for l2 != nil {
		current.Next = l2
		l2 = l2.Next
		current = current.Next
	}

	return head
}
