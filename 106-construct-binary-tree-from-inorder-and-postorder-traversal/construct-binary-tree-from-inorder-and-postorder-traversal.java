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
        return construct(inorder, 0, inorder.length - 1, postorder, 0, postorder.length - 1, map);
    }
    private TreeNode construct(int[] inorder, int inleft, int inright, 
    int[] postorder, int postleft, int postright, Map<Integer, Integer> map)
    {
        if (postleft > postright) {
            return null;
        }
        TreeNode head = new TreeNode(postorder[postright]);
        int headIdx = map.get(head.val);
        int leftRange = headIdx - inleft;

        head.left = construct(inorder, inleft, headIdx - 1,
        postorder, postleft, postleft + leftRange - 1, map);

        head.right = construct(inorder, headIdx + 1, inright,
        postorder, postleft + leftRange, postright - 1, map);
        return head;
    }
}
//     1
// 2       3
//     4       5
// inorder: 2 1 4 3 5
//          l h 
// postorder: 2 4 5 3 1
//            l r r r h