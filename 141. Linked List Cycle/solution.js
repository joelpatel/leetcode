var hasCycle = function(head) {
    if (head === null) {
        return false;
    }

    let first = head;
    let second = head.next;

    while (second !== null && second.next !== null) {
        first = first.next;
        second = second.next.next;

        if (first === second) {
            return true;
        }
    }
    
    return false;
};