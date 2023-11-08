// 2
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
public class Solution {
    public ListNode reverseListIteratively(ListNode head) {
        ListNode prev = null, next;

        while (head != null) {
            next = head.next;
            head.next = prev;
            prev = head;
            head = next;
        }

        return prev;
    }

    public ListNode reverseList(ListNode head) {
        return recursive(null, head);
    }

    public ListNode recursive(ListNode prev, ListNode current) {
        if (current == null) {
            return current;
        } else if (current.next == null) { // exit case
            current.next = prev;
            return current;
        }

        ListNode next = current.next;
        current.next = prev;

        return recursive(current, next);
    }
}