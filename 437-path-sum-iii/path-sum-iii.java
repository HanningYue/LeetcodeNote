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
    public int pathSum(TreeNode root, int targetSum) {
        Map<Long, Integer> map = new HashMap<>();
        return dfs(root, targetSum, map, 0l);
    }
    private int dfs(TreeNode root, int targetSum, Map<Long, Integer> map, Long pathSum) {
        if (root == null) {
            return 0;
        }
        int count = 0;
        pathSum += root.val;
        if (pathSum == targetSum) {
            count++;
        }
        count += map.getOrDefault(pathSum - targetSum, 0);
        map.put(pathSum, map.getOrDefault(pathSum, 0) + 1);

        count += dfs(root.left, targetSum, map, pathSum);
        count += dfs(root.right, targetSum, map, pathSum);

        map.put(pathSum, map.getOrDefault(pathSum, 1) - 1);
        return count;
    }
}