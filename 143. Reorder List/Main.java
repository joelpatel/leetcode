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
        return "{" +
                "val=" + val +
                ", next=" + next +
                '}';
    }
}

class Main {
    public static void main(String[] args) {
        System.out.println("143. Reorder List");

        ListNode l5 = new ListNode(5);
        ListNode l4 = new ListNode(4, l5);
        ListNode l3 = new ListNode(3, l4);
        ListNode l2 = new ListNode(2, l3);
        ListNode l1 = new ListNode(1, l2);

        Solution solution = new Solution();
        solution.reorderList(l1);

        System.out.println(l1);
    }
}

// class Solution {
//     public void reorderList(ListNode head) {
//         if (head == null || head.next == null) {
//             return;
//         }

//         // figure out the second half
//         ListNode start, end;
//         start = head;
//         end = head.next;

//         while (end != null && end.next != null) {
//             start = start.next;
//             end = end.next.next;
//         }

//         ListNode next = start.next;
//         start.next = null; // the last element

//         // reversing the second half of the linked list
//         ListNode prev = null;
//         while (next != null) {
//             ListNode temp = next.next;
//             next.next = prev;
//             prev = next;
//             next = temp;
//         } // prev will be the start of the second list

//         // merge two lists
//         while (head != null && prev != null) {
//             ListNode oldHeadNext = head.next;
//             ListNode oldPrevNext = prev.next;
//             head.next = prev;
//             prev.next = oldHeadNext;
//             head = oldHeadNext;
//             prev = oldPrevNext;
//         }
//     }
// }