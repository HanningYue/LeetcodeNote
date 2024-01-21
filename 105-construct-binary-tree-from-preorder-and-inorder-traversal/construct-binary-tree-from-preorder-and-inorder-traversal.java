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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }
        return dfs(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1, map);
    }
    private TreeNode dfs(int[] preorder, int preleft, int preright, 
    int[] inorder, int inleft, int inright, Map<Integer, Integer> map) {
        if (preleft > preright) {
            return null;
        }
        TreeNode newHead = new TreeNode(preorder[preleft]);
        int mid = map.get(newHead.val);
        newHead.left = dfs(preorder, preleft + 1, preleft + mid - inleft, inorder, inleft, mid - 1, map);
        newHead.right = dfs(preorder, preleft + mid - inleft + 1, preright, inorder, mid + 1, inright, map);
        return newHead;
    }
}