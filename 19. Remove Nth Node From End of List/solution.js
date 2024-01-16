function removeNthFromEnd(head, n) {
    let start = head;

    let count = 0;
    while (count < n && head !== null) {
        head = head.next
        count++;
    }

    let prev = undefined;
    let second = start;

    while (head !== null) {
        prev = second;
        second = second.next;
        head = head.next;
    }

    if (prev !== undefined) {
        prev.next = second.next;
        second.next = undefined;
    } else {
        start = second.next;
        second.next = undefined;
    }

    return start;
}