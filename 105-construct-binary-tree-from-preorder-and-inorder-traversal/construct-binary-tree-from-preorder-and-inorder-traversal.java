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
        Map<Integer, Integer> map = new HashMap<>();//{inorder value, inorder index}
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }
        return build(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1, map);
    }
    private TreeNode build(int[] preorder, int preleft, int preright, int[] inorder, int inleft, int inright, 
    Map<Integer, Integer> map)
    {
        if (preleft > preright) {
            return null;
        }
        TreeNode root = new TreeNode(preorder[preleft]);
        int headIdx = map.get(root.val);
        int leftSize = headIdx - inleft;

        root.left = build(preorder, preleft + 1, preleft + leftSize, inorder, inleft, headIdx - 1, map);
        root.right = build(preorder, preleft + leftSize + 1, preright, inorder, headIdx + 1, inright, map);

        return root;
    }
}