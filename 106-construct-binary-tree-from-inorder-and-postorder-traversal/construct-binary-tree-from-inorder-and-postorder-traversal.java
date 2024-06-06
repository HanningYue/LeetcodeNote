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
    private TreeNode recursion(int[] inorder, int inleft, int inright, 
    int[] postorder, int postleft, int postright) {
        if (inleft > inright) {
            return null;
        }

        int headValue = postorder[postright];
        int headIndex = map.get(headValue);
        int leftSubtreeSize = headIndex - inleft;

        TreeNode root = new TreeNode(headValue);
        root.left = recursion(inorder, inleft, headIndex - 1, 
        postorder, postleft, postleft + leftSubtreeSize - 1);

        root.right = recursion(inorder, headIndex + 1, inright, 
        postorder, postleft + leftSubtreeSize, postright - 1);
        return root;

    }
}
/**
9 3 15 20 7
9 15 7 20 3
0 1  2  3 4
*/