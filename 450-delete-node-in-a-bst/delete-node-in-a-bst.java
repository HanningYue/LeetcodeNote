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
    public TreeNode deleteNode(TreeNode root, int key) {
        if (root == null) {
            return null;
        }
        if (root.val == key) {
            if (root.left == null) {
                root = root.right;
                return root;
            } 
            else if (root.right == null) {
                root = root.left;
                return root;
            } 
            else {
                TreeNode rightMin = getRightMin(root.right);
                root.val = rightMin.val;
                root.right = deleteNode(root.right, rightMin.val);
            }
        } else if (root.val < key) {
            root.right = deleteNode(root.right, key);
        } else if (root.val > key) {
            root.left = deleteNode(root.left, key);
        }
        return root;
    }
    private TreeNode getRightMin(TreeNode root) {
        while (root.left != null) {
            root = root.left;
        }
        return root;
    }
}