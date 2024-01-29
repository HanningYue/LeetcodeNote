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
We need to insert, what we need? 
The correct position of this inserting root, so if val > root.val, root.right = insert(root.right)
if val < root.val, root.left = insert(root.left)
Since the node is guaranteed that the new value does not exist in the original BST. 
We can insert at the null space. When inserting, when null, create new TreeNode
*/
class Solution {
    public TreeNode insertIntoBST(TreeNode root, int val) {
        if (root == null) {
            TreeNode insert = new TreeNode(val);
            return insert;
        }
        if (root.val < val) {
            root.right = insertIntoBST(root.right, val);
        } else if (root.val > val) {
            root.left = insertIntoBST(root.left, val);
        }
        return root;
    }
}