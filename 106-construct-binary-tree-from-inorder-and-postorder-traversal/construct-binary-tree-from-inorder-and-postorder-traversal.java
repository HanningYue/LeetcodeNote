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
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }
        return build(inorder, 0, inorder.length - 1, postorder, 0, postorder.length - 1, map);
    }
    private TreeNode build(int[] inorder, int inleft, int inright, int[] postorder, int postleft, int postright, 
    Map<Integer, Integer> map)
    {
        if (postleft > postright) {
            return null;
        }
        TreeNode head = new TreeNode(postorder[postright]);
        int headIdx = map.get(head.val);
        int leftSize = headIdx - inleft;
        
        head.left = build(inorder, inleft, headIdx - 1, postorder, postleft, postleft + leftSize - 1, map);
        head.right = build(inorder, headIdx + 1, inright, postorder, postleft + leftSize, postright - 1, map);

        return head;
    }
}