import java.util.Map;
import java.util.HashMap;

class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }

    @java.lang.Override
    public java.lang.String toString() {
        return "{" +
                "val=" + val +
                ", next=" + (next != null ? next.val : "null") +
                ", random=" + (random != null ? random.val : "null") +
                '}';
    }
}

class Main {
    public static void main(String[] args) {
        System.out.println("138. Copy List with Random Pointer");

        Node n1 = new Node(7);
        Node n2 = new Node(13);
        Node n3 = new Node(11);
        Node n4 = new Node(10);
        Node n5 = new Node(1);

        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;

        n2.random = n1;
        n3.random = n5;
        n4.random = n3;
        n5.random = n1;

        Solution solution = new Solution();
        Node result = solution.copyRandomList(n1);
        while (result != null) {
            System.out.println(result);
            result = result.next;
        }
    }
}

class Solution {
    public Node copyRandomList(Node head) {
        Map<Node, Node> hashMap = new HashMap<>();

        Node first = head;

        while (head != null) {
            Node nCopy = new Node(head.val);
            hashMap.put(head, nCopy);
            head = head.next;
        }

        head = first;
        while (head != null) {
            hashMap.get(head).next = hashMap.get(head.next);
            head = head.next;
        }

        head = first;
        while (head != null) {
            hashMap.get(head).random = hashMap.get(head.random);
            head = head.next;
        }

        return hashMap.get(first);
    }
}