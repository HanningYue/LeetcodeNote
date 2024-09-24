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
    Map<Integer, Integer> map;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        map = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }
        return recursion(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1);
    }
    private TreeNode recursion(int[] preorder, int preleft, int preright, int[] inorder, int inleft, int inright) {
        if (preleft > preright) {
            return null;
        }
        int headValue = preorder[preleft];
        int headIndex = map.get(headValue);
        int leftSubSize = headIndex - inleft;

        TreeNode head = new TreeNode(headValue);
        head.left = recursion(preorder, preleft + 1, preleft + leftSubSize, inorder, inleft, headIndex - 1);
        head.right = recursion(preorder, preleft + leftSubSize + 1, preright, inorder, headIndex + 1, inright);
        return head;
    }
}