class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }

    @java.lang.Override
    public java.lang.String toString() {
        return "{" +
                "val=" + val +
                ", next=" + next +
                '}';
    }
}

class Main {
    public static void main(String[] args) {
        System.out.println("19. Remove Nth Node From End of List");

        /*
        ListNode l5 = new ListNode(5);
        ListNode l4 = new ListNode(4, l5);
        ListNode l3 = new ListNode(3, l4);
        ListNode l2 = new ListNode(2, l3);
        ListNode l1 = new ListNode(1, l2);
        */
        ListNode l1 = new ListNode(1);


        Solution solution = new Solution();
        ListNode result = solution.removeNthFromEnd(l1, 1);

        System.out.println(result);
    }
}

class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode lptr = head, rptr = head;
        int diff = n-1;
        while (diff > 0) {
            rptr = rptr.next;
            diff--;
        }

        // traverse both pointers
        ListNode prev = null;
        while (rptr.next != null) {
            prev = lptr;
            lptr = lptr.next;
            rptr = rptr.next;
        }

        if (prev != null) {
            prev.next = lptr.next;
        } else {
            head = lptr.next;
        }

        return head;
    }
    public ListNode removeNth(ListNode head, int n) {
        ListNode first = head;
        n--;// because first is already scanned
        ListNode prev = null;
        while (n > 0) {
            prev = head;
            head = head.next;
            n--;
        }

        if (prev != null) {
            prev.next = head.next;
        } else {
            first = head.next;
        }

        return first;
    }
}