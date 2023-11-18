/*
    Integer _, Integer _
1. Return boolean, we need to check
    The current node is greater than the MAXIMUM of left subtree, 
                     is less than the MINIMUM of right subtree
2. When checking left and right subtree is also BST, left root.val be 
    the rightMinimum when checking left-subtree
    the leftMaximum when checking right-subtree
*/
class Solution {
    public boolean isValidBST(TreeNode root) {
        return isBST(root, null, null);
    }
    private boolean isBST (TreeNode root, Integer leftMax, Integer rightMin) {
        if (root == null) return true;
        
        if (leftMax != null && root.val <= leftMax
          ||rightMin != null && root.val >= rightMin)
        {
            return false;
        }
        
        boolean leftBST = isBST(root.left, leftMax, root.val);
        boolean rightBST = isBST(root.right, root.val, rightMin);
        return leftBST && rightBST;
    }
}