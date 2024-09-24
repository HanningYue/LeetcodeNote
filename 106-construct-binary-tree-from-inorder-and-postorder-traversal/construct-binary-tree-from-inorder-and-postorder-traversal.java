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
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        map = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }
        return recursion(inorder, 0, inorder.length - 1, postorder, 0, postorder.length - 1);
    }
    private TreeNode recursion(int[] inorder, int inleft, int inright, int[] postorder, int postleft, int postright) {
        if (postleft > postright) {
            return null;
        }
        int headValue = postorder[postright];
        int headIndex = map.get(headValue);
        int leftSubSize = headIndex - inleft - 1;

        TreeNode head = new TreeNode(headValue);
        head.left = recursion(inorder, inleft, headIndex - 1, postorder, postleft, postleft + leftSubSize);
        head.right = recursion(inorder, headIndex + 1, inright, postorder, postleft + leftSubSize + 1, postright - 1);
        return head;
    }
}
