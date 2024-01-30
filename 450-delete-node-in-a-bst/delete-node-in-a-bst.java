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
If node going to delete is leaf, delete it
    if (root.left == null && root.right == null) {
        return null;
    }
If node going to delete has only one child, switch that child to the position
    if (root.left == null) {
        return root.right
    } else if (root.right == null) {
        return root.left;
    }

If node going to delete has two children
    Either, we find the smallest node in right subtree
    if (root.left != null && root.right != null) {
        TreeNode minRightSub = getMin(root.right);
        //Delete the minRightSub
        root.right = deleteNode(root.right, minNode.val)
        
        minNode.left = root.left;
        minNode.right = root.right;
        root = minNode;
    }

getMin(TreeNode root)
*/
class Solution {
    public TreeNode deleteNode(TreeNode root, int key) {
        if (root == null) {
            return null;
        }

        if (root.val == key) {
            if (root.left == null) {
                return root.right;
            }            
            if (root.right == null) {
                return root.left;
            }
            TreeNode minNode = getMin(root.right);
            root.right = deleteNode(root.right, minNode.val);
            root.val = minNode.val;
        } 
        else if (root.val < key) {
            root.right = deleteNode(root.right, key);
        } 
        else if (root.val > key) {
            root.left = deleteNode(root.left, key);
        }

        return root;
    }
    private TreeNode getMin(TreeNode root) {
        while (root.left != null) {
            root = root.left;
        }
        return root;
    }
}