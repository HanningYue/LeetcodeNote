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
    private TreeNode build(int[] inorder, int inleft, int inright, 
    int[] postorder, int postleft, int postright, Map<Integer, Integer> map) 
    {
        if (inleft > inright) {
            return null;
        }
        TreeNode newHead = new TreeNode(postorder[postright]);
        int headIndex = map.get(newHead.val);
        newHead.left = build(inorder, inleft, headIndex - 1, 
        postorder, postleft, headIndex - inleft + postleft - 1, map);

        newHead.right = build(inorder, headIndex + 1, inright,
        postorder, headIndex - inleft + postleft, postright - 1, map);
        return newHead;
    }
}