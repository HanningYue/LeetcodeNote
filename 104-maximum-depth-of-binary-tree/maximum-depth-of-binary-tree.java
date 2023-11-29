/**
Two scenarios : 
    1           1
   /     or    / \
  2           2   3  
 /
3  
Consider the regular case and the case when one side is null*/

class Solution {
    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = maxDepth(root.left);
        int right = maxDepth(root.right);
        return Math.max(left, right) + 1;
    }
}