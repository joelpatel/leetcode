function isNil(element) {
    return (element === null || element === undefined);
}

var isValidBST = function(root) {
    return validate(root);
}

function validate(node, min, max) {
    if (isNil(node)) {
        return true;
    }

    if (!isNil(max) && node.val >= max.val) {
        return false;
    }

    if (!isNil(min) && node.val <= min.val) {
        return false;
    }

    return validate(node.left, min, node) && validate(node.right, node, max);
}