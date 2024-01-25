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
        return dfs(root, targetSum, 0l, map);
    }
    private int dfs(TreeNode root, int targetSum, Long pathSum, Map<Long, Integer> map) {
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

        count += dfs(root.left, targetSum, pathSum, map);
        count += dfs(root.right, targetSum, pathSum, map);

        map.put(pathSum, map.getOrDefault(pathSum, 1) - 1);

        return count;
    }
}