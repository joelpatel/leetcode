class ListNode {
    int val;
    ListNode next;
    ListNode() {}
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
        System.out.println("21. Merge Two Sorted Lists");

//        ListNode l5 = new ListNode(5);
//        ListNode l3 = new ListNode(3, l5);
//        ListNode l1 = new ListNode(1, l3);
        ListNode l1 = new ListNode(1);

//        ListNode l4 = new ListNode(4);
//        ListNode l2 = new ListNode(2, l4);
        ListNode l2 = new ListNode(2);

        Solution solution = new Solution();
        ListNode head = solution.mergeTwoLists(l1, l2);
        System.out.println(">> result: " + head);
    }
}

class Solution {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if (list1 == null) {
            return list2;
        }
        if (list2 == null) {
            return list1;
        }

        ListNode first, head;
        if (list1.val <= list2.val) {
            first = list1;
            list1 = list1.next;
        } else {
            first = list2;
            list2 = list2.next;
        }

        head = first;

        while (list1 != null && list2 != null) {
            if (list1.val <= list2.val) {
                head.next = list1;
                list1 = list1.next;
                head = head.next;
            } else {
                head.next = list2;
                list2 = list2.next;
                head = head.next;
            }
        }

        while (list1 != null) {
            head.next = list1;
            list1 = list1.next;
            head = head.next;
        }

        while (list2 != null) {
            head.next = list2;
            list2 = list2.next;
            head = head.next;
        }

        return first;
    }
}