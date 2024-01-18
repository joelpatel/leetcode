function merge2Lists(l1, l2) {
    let start;
    if (l1 === undefined || l1 === null) {
        return l2;
    } else if (l2 === undefined || l2 === null) {
        return l1;
    } else if (l1.val <= l2.val) {
        start = l1;
        l1 = l1.next;
    } else {
        start = l2;
        l2 = l2.next;
    }

    let head = start;
    while (l1 !== undefined && l1 !== null && l2 !== undefined && l2 !== null) {
        if (l1.val <= l2.val) {
            head.next = l1
            l1 = l1.next;
        } else {
            head.next = l2;
            l2 = l2.next;
        }
        head = head.next;
        head.next = null;
    }

    if (l1 !== undefined && l1 !== null) {
        head.next = l1;
    } else if (l2 !== undefined && l2 !== null) {
        head.next = l2;
    }

    return start;
}

var mergeKLists = function(lists) {
    if (lists === undefined || lists.length === 0) {
        return null;
    }

    while (lists.length > 1) {
        let temp = [];
        for (i = 0; i < lists.length; i += 2) {
            let l1 = lists[i]
            let l2;
            if (i + 1 < lists.length) {
                l2 = lists[i + 1];
            }
            let merged = merge2Lists(l1, l2);
            if (merged !== undefined && merged !== null) {
                temp.push(merged);
            }
        }
        lists = temp;
    }

    if (lists.length === 0) {
        return null;
    } else {
        return lists[0]
    }
}