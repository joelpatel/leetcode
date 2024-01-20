function isNil(element) {
    if (element === undefined || element === null) {
        return true;
    } else {
        return false;
    }
}

var maxDepth = function(root) {
    if (isNil(root)) {
        return 0;
    }

    return 1 + Math.max(maxDepth(root.left), maxDepth(root.right));
}