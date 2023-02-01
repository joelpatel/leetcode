class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
        next = null;
    }
}

class Main {
    public static void main(String[] args) {
        System.out.println("141. Linked List Cycle");

        ListNode l1 = new ListNode(1), l2 = new ListNode(2), l3 = new ListNode(3), l4 = new ListNode(4);

        l1.next = l2;
        l2.next = l3;
        l3.next = l4;
        l4.next = l2;
        // l1 = null;

        Solution solution = new Solution();
        System.out.println(">> result: " + solution.hasCycle(l1));
    }
}

/*
 * class Solution {
 * public boolean hasCycle(ListNode head) {
 * ListNode next = null;
 * while (head != null && head != head.next) {
 * next = head.next;
 * head.next = head;
 * head = next;
 * }
 * return head == null ? false : true;
 * }
 * }
 */

class Solution {
    public boolean hasCycle(ListNode head) {
        if (head == null) {
            return false;
        }
        ListNode slow = head, fast = head.next;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                return true;
            }
        }

        return false;
    }
}