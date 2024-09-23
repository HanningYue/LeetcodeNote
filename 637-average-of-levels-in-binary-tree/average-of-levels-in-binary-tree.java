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
    public List<Double> averageOfLevels(TreeNode root) {
        List<Double> levelSum = new ArrayList<>();
        List<Integer> nodeCount = new ArrayList<>();
        dfs(root, levelSum, nodeCount, 0);
        for (int i = 0; i < levelSum.size(); i++) {
            levelSum.set(i, levelSum.get(i) / nodeCount.get(i));
        }
        return levelSum;
    }
    private void dfs(TreeNode root, List<Double> levelSum, List<Integer> nodeCount, int level) {
        if (root == null) {
            return;
        }
        if (levelSum.size() == level) {
            levelSum.add(root.val * 1.0);
            nodeCount.add(1);
        } else if (levelSum.size() > level) {
            levelSum.set(level, levelSum.get(level) + root.val);
            nodeCount.set(level, nodeCount.get(level) + 1);
        }
        dfs(root.left, levelSum, nodeCount, level + 1);
        dfs(root.right, levelSum, nodeCount, level + 1);
    }
}