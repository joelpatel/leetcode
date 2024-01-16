public class Solution {
    public void reorderList(ListNode head) {
        int n = 0;

        // pass-1: reverse order while incrementing n
        ListNode prev = null, next;
        while (head != null) {
            next = head.next;
            head.next = prev;
            prev = head;
            head = next;
            n++;
        }
        
        ListNode last = prev;

        // pass-2: skip n/2, break linked list, reverse order for the rest
        int skipped = 0;
        while (skipped < n/2 - 1) {
            prev = prev.next;
            skipped++;
        }
        head = prev.next;
        prev.next = null;
        head = reverse(head);

        // pass-3: merge both linked list alternatively
        merge(head, last);
    }

    public ListNode reverse(ListNode head) {
        ListNode prev = null, next;

        while (head != null) {
            next = head.next;
            head.next = prev;
            prev = head;
            head = next;
        }

        return prev;
    }

    public void merge(ListNode l1, ListNode l2) {
        if (l1 == l2 || l1 == null || l2 == null) { // for single element or null
            return;
        }

        boolean alt = false;

        ListNode head = l1;
        l1 = l1.next;

        while (head != null) {
            if (!alt) {
                head.next = l2;
                if (l2 != null) l2 = l2.next;
            } else {
                head.next = l1;
                if (l1 != null) l1 = l1.next;
            }
            
            head = head.next;
            alt = !alt;
        }
    }
}