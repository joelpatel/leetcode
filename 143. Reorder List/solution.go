package main

/**
 * Definition for singly-linked list.
 * type ListNode struct {
 *     Val int
 *     Next *ListNode
 * }
 */
func reorderList(head *ListNode) {
	// find middle
	slow, fast := head, head.Next
	for fast != nil && fast.Next != nil {
		slow = slow.Next
		fast = fast.Next.Next
	}

	// reverse second half
	second := slow.Next
	slow.Next = nil
	var prev, tmp1, tmp2 *ListNode
	for second != nil {
		tmp1 = second.Next
		second.Next = prev
		prev = second
		second = tmp1
	}

	// merge two halves
	first, second := head, prev
	for second != nil {
		tmp1, tmp2 = first.Next, second.Next
		first.Next = second
		second.Next = tmp1
		first, second = tmp1, tmp2
	}
}
