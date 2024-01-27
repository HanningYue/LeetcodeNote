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
    Map<String, Integer> map = new HashMap<>();
    List<TreeNode> result = new ArrayList<>();
    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        traverse(root);
        return result;
    }
    private String traverse(TreeNode root) {
        if (root == null) {
            return "#";
        }
        String leftPath = traverse(root.left);
        String rightPath = traverse(root.right);
        String path = leftPath + " " + rightPath + " " + root.val;
        
        int freq = map.getOrDefault(path, 0);
        if (freq == 1) {
            result.add(root);
        }
        map.put(path, freq + 1);
        return path;
    }
}