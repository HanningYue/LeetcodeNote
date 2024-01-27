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
    public TreeNode constructFromPrePost(int[] preorder, int[] postorder) {
        int[] preindex = {0}, postindex = {0};
        return build(preorder, preindex, postorder, postindex);
    }
    private TreeNode build(int[] preorder, int[] preindex, 
    int[] postorder, int[] postindex) 
    {
        if (preindex[0] == preorder.length) {
            return null;
        }
        TreeNode root = new TreeNode(preorder[preindex[0]++]);
        if (root.val != postorder[postindex[0]]) {
            root.left = build(preorder, preindex, postorder, postindex);
        }
        if (root.val != postorder[postindex[0]]) {
            root.right = build(preorder, preindex, postorder, postindex);
        }
        postindex[0]++;
        return root;
    }
}