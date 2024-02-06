class Solution {
    public boolean isValidBST(TreeNode root) {
        return validate(root, null, null);
    }

    private boolean validate(TreeNode node, TreeNode min, TreeNode max) {
        if (node == null) {
            return true;
        }

        if ((max != null && node.val >= max.val) || (min != null && node.val <= min.val)) {
            return false;
        }

        return validate(node.left, min, node) && validate(node.right, node, max);
    }
}
