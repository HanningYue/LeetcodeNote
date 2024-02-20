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
        return construct(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1, map);
    }
    private TreeNode construct(int[] preorder, int preleft, int preright, 
    int[] inorder, int inleft, int inright, Map<Integer, Integer> map)
    {
        if (preleft > preright) {
            return null;
        }

        TreeNode head = new TreeNode(preorder[preleft]);
        int headIdx = map.get(head.val);
        int leftRange = headIdx - inleft;

        head.left = construct(preorder, preleft + 1, preleft + leftRange,
        inorder, inleft, headIdx - 1, map);
        head.right = construct(preorder, preleft + leftRange + 1, preright, 
        inorder, headIdx + 1, inright, map);
        return head;
    }
}
//     1
// 2       3
//     4       5
// pre: 1 2 3 4 5
// in:  2 1 4 3 5
