package main

func mergeKLists(lists []*ListNode) *ListNode {
	if len(lists) == 0 {
		return nil
	}

	for len(lists) > 1 {
		var tempMergedLists []*ListNode
		for i := 0; i < len(lists); i += 2 {
			l1 := lists[i]
			var l2 *ListNode
			if i+1 < len(lists) {
				l2 = lists[i+1]
			}

			l := merge2Lists(l1, l2)
			if l != nil {
				tempMergedLists = append(tempMergedLists, l)
			}
		}

		lists = tempMergedLists
	}

	if len(lists) == 0 {
		return nil
	} else {
		return lists[0]
	}
}

// return pointer can be nil
func merge2Lists(l1, l2 *ListNode) *ListNode {
	var first *ListNode

	if l1 == nil {
		return l2
	} else if l2 == nil {
		return l1
	} else if l1.Val <= l2.Val {
		first = l1
		l1 = l1.Next
	} else {
		first = l2
		l2 = l2.Next
	}

	head := first
	for l1 != nil && l2 != nil {
		if l1.Val <= l2.Val {
			head.Next = l1
			l1 = l1.Next
		} else {
			head.Next = l2
			l2 = l2.Next
		}
		head = head.Next
		head.Next = nil
	}

	if l1 != nil {
		head.Next = l1
	} else if l2 != nil {
		head.Next = l2
	}

	return first
}
