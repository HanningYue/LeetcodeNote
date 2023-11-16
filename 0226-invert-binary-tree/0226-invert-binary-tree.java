/*
1. 向右边要右边invert过的tree，向左边要左边invert过的tree
2. 当前这层 declare 一个新head 把左边指向原来node右边 把右边指向原来node左边
3. 返回invert过的 tree
*/
class Solution {
    public TreeNode invertTree(TreeNode root) {
        if (root == null) return null;
        
        TreeNode newHead = new TreeNode(root.val);
        newHead.right = invertTree(root.left);
        newHead.left = invertTree(root.right);
        return newHead;
    }
}