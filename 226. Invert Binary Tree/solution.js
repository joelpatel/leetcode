var invertTree = function(root) {
    if (root === null) {
        return null;
    }

    [root.left, root.right] = [root.right, root.left];
    if (root.left !== null) {
        invertTree(root.left);
    }
    if (root.right !== null) {
        invertTree(root.right);
    }

    return root;
};