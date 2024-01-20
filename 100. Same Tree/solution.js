function isNil(element) {
    if (element === undefined || element === null) {
        return true;
    } else {
        return false;
    }
}

var isSameTree = function(p, q) {
    if (isNil(p) === true && isNil(q) === true) {
        return true;
    }

    if (isNil(p) || isNil(q) || p.val !== q.val) {
        return false;
    }

    return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
}