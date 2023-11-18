/*
In a BST, for any given node:
All nodes in its left subtree must have values less than the node's value.
All nodes in its right subtree must have values greater than the node's value.
    Integer _, Integer _
1. Return boolean, we need to check
    The current node is GREATER than the MAXIMUM of left subtree, 
                     is LESS than the MINIMUM of right subtree
2. When checking left and right subtree is also BST, left root.val be 
    the rightMin when checking left-subtree, we update rightMin from null to root.val
    the leftMax when checking right-subtree, we update leftMax from null to root.val
*/
class Solution {
    public boolean isValidBST(TreeNode root) {
        return isBST(root, null, null);
    }
    private boolean isBST(TreeNode root, Integer leftMax, Integer rightMin) {
        if (root == null) return true;
        
        if (leftMax != null && root.val <= leftMax 
            || rightMin != null && rightMin <= root.val) 
        {
            return false;    
        }
        
        boolean leftBST = isBST(root.left, leftMax, root.val);
        boolean rightBST = isBST(root.right, root.val, rightMin);
        return leftBST && rightBST;
    }
}