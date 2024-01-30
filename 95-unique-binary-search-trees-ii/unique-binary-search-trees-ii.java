/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public List<TreeNode> generateTrees(int n) {
        return build(1, n);
    }
    private List<TreeNode> build(int start, int end) {
        List<TreeNode> result = new ArrayList<>();
        if (start > end) {
            result.add(null);
            return result;
        }

        for (int mid = start; mid <= end; mid++) {
            List<TreeNode> leftTree = build(start, mid - 1);
            List<TreeNode> rightTree = build(mid + 1, end);

            for (TreeNode left : leftTree) {
                for (TreeNode right : rightTree) {
                    TreeNode root = new TreeNode(mid);
                    root.left = left;
                    root.right = right;
                    result.add(root);
                }
            }
        }
        return result;
    }
}