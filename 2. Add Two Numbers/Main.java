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

    @Override
    public String toString() {
        return "{val=" + val + ", next=" + next + "}";
    }

}

class Main {
    public static void main(String[] args) {
        System.out.println("2. Add Two Numbers");

        ListNode n1 = new ListNode(), n2 = new ListNode(), n3 = new ListNode(), m1 = new ListNode(),
                m2 = new ListNode(), m3 = new ListNode(), m4 = new ListNode();

        n1.val = 2;
        n1.next = n2;
        n2.val = 4;
        n2.next = n3;
        n3.val = 9;

        m1.val = 5;
        m1.next = m2;
        m2.val = 6;
        m2.next = m3;
        m3.val = 4;
        m3.next = m4;
        m4.val = 9;

        Solution solution = new Solution();
        ListNode result = solution.addTwoNumbers(n1, m1);
        System.out.println(">> result = " + result);
    }
}

class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode first = l1, prev = null;

        int sum, carry = 0;
        while (l1 != null && l2 != null) {
            sum = carry + l1.val + l2.val;
            if (sum >= 10) {
                sum -= 10;
                carry = 1;
            } else {
                carry = 0;
            }

            l1.val = sum;
            prev = l1;
            l1 = l1.next;
            l2 = l2.next;
        }

        while (l1 != null) {
            sum = carry + l1.val;
            if (sum >= 10) {
                sum -= 10;
                carry = 1;
            } else {
                carry = 0;
            }

            l1.val = sum;
            prev = l1;
            l1 = l1.next;
        }

        if (l2 != null) {
            l1 = prev;
            l1.next = l2;
            l1 = l2;

            while (l1 != null) {
                sum = carry + l1.val;
                if (sum >= 10) {
                    sum -= 10;
                    carry = 1;
                } else {
                    carry = 0;
                }

                l1.val = sum;
                prev = l1;
                l1 = l1.next;
            }
        }

        if (carry == 1) {
            ListNode end = new ListNode();
            prev.next = end;
            end.val = 1;
        }

        return first;
    }
}