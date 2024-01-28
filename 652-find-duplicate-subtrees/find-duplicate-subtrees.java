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
    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        Map<String, Integer> map = new HashMap<>();//{Stringpath, Frequency}
        List<TreeNode> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        dfs(root, result, map);
        return result;
    }
    private String dfs(TreeNode root, List<TreeNode> result, Map<String, Integer> map) {
        if (root == null) {
            return "#";
        }
        String leftPath = dfs(root.left, result, map);
        String rightPath = dfs(root.right, result, map);
        String currentPath = leftPath + "," + rightPath + "," + root.val;
        
        int freq = map.getOrDefault(currentPath, 0);
        if (freq == 1) {
            result.add(root);
        }
        map.put(currentPath, map.getOrDefault(currentPath, 0) + 1);
        return currentPath;
    }
}