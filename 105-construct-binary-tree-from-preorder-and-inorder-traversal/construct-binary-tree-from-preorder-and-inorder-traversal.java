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
        return build(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1, map);
    }
    private TreeNode build(int[] preorder, int preleft, int preright, 
    int[] inorder, int inleft, int inright, Map<Integer, Integer> map) 
    {
        if (preleft > preright) {
            return null;
        }
        TreeNode head = new TreeNode(preorder[preleft]);
        int headIdxInorder = map.get(head.val);
        int leftSize = headIdxInorder - inleft;

        head.left = build(preorder, preleft + 1, preleft + leftSize, 
        inorder, inleft, headIdxInorder - 1, map);

        head.right = build(preorder, preleft + leftSize + 1, preright,
        inorder, headIdxInorder + 1, inright, map);
        
        return head;
    }
}