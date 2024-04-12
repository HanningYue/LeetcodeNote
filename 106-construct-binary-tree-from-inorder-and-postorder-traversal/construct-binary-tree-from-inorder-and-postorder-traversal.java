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
        return dfs(map, postorder, 0, postorder.length - 1, inorder, 0, inorder.length - 1);
    }
    private TreeNode dfs(Map<Integer, Integer> map, int[] postorder, int postleft, int postright,
    int[] inorder, int inleft, int inright) {
        if (postleft > postright) {
            return null;
        }
        int headValue = postorder[postright];
        int headIndex = map.get(headValue);
        int leftSize = headIndex - inleft;

        TreeNode newHead = new TreeNode(headValue);
        newHead.left = dfs(map, postorder, postleft, postleft + leftSize - 1, inorder, inleft, headIndex - 1);
        newHead.right = dfs(map, postorder, postleft + leftSize, postright - 1, inorder, headIndex + 1, inright);
        return newHead;
    }
}
/**
9 3 15 20 7
9 15 7 20 3
0 1  2  3 4
*/