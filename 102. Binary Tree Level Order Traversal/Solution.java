import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> levels = new ArrayList<>();

        if (root == null) {
            return levels;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            List<Integer> level = new ArrayList<>();
            int length = queue.size();

            for (int i = 0; i < length; i++) {
                TreeNode element = queue.poll();
                if (element.left != null) {
                    queue.add(element.left);
                }
                if (element.right != null) {
                    queue.add(element.right);
                }

                level.add(element.val);
            }

            levels.add(level);
        }

        return levels;
    }
}
