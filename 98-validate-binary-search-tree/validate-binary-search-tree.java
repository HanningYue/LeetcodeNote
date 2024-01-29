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
 /**
The current root has to be smaller than the right min and greater than the left max
Solve by recursion, We need three nodes, root, min and max
At current level, need left valid, set max of left-sub-tree to current root
need right valid, set min of right-sub-tree to current root. 
*/
class Solution {
    public boolean isValidBST(TreeNode root) {
        return isValid(root, null, null);
    }
    private boolean isValid(TreeNode root, TreeNode min, TreeNode max) {
        if (root == null) {
            return true;
        }
        if (min != null && root.val <= min.val) {
            return false;
        }
        if (max != null && root.val >= max.val) {
            return false;
        }
        boolean leftValid = isValid(root.left, min, root);
        boolean rightValid = isValid(root.right, root, max);
        return leftValid && rightValid;
    }
}