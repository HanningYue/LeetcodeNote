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
        List<Integer> result = new ArrayList<>();
        return dfs(root, targetSum, result);
    }
    private int dfs(TreeNode root, int targetSum, List<Integer> result) {
        if (root == null) {
            return 0;
        }
        
        long pathSum = 0;
        int count = 0;
        result.add(root.val);
        for (int i = result.size() - 1; i >= 0; i--) {
            pathSum += result.get(i);
            if (pathSum == targetSum) {
                count++;
            }
        }

        count += dfs(root.left, targetSum, result);
        count += dfs(root.right, targetSum, result);
        result.remove(result.size() - 1);
        return count;
    }
}