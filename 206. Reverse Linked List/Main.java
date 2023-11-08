public class Main {
    public static void main(String[] args) {
        System.out.println("206. Reverse Linked List");

        ListNode l5 = new ListNode(5);
        ListNode l4 = new ListNode(4, l5);
        ListNode l3 = new ListNode(3, l4);
        ListNode l2 = new ListNode(2, l3);
        ListNode l1 = new ListNode(1, l2);

        Solution solution = new Solution();
        ListNode head = solution.reverseList(l1);
        System.out.println(">> result: " + head);
    }
}

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

    @Override
    public String toString() {
        return "{" +
                "val=" + val +
                ", next=" + next +
                '}';
    }
}


// 1
// class Solution {
//     public ListNode reverseList(ListNode head) {
//         if (head == null || head.next == null) {
//             return head;
//         }
//         ListNode previous, current, next;
//         previous = null;
//         current = head;
//         next = head.next;

//         while (current.next != null) {
//             current.next = previous;
//             previous = current;
//             current = next;
//             next = next.next;
//         }

//         if (current != null) {
//             current.next = previous;
//         }

//         return current;
//     }
// }