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
    public int countNodes(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int depth = findDepth(root);
        int lastLevel = countNode(root, depth);
        return (int)Math.pow(2, depth) - 1 + lastLevel;
    }

    private int findDepth(TreeNode root) {
        int depth = 0;
        while (root.left != null) {
            root = root.left;
            depth++;
        }
        return depth;
    }

    private boolean binarySearch(TreeNode root, int index, int depth) {
        int left = 0, right = (int)Math.pow(2, depth) - 1;
        for (int i = 0; i < depth; i++) {
            int mid = left + (right - left) / 2;
            if (mid >= index) {
                root = root.left;
                right = mid;
            } else {
                root = root.right;
                left = mid + 1;
            }
        }
        return root == null ? false : true;
    }

    private int countNode(TreeNode root, int depth) {
        int left = 0, right = (int)Math.pow(2, depth) - 1; // Adjust left bound to 0
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (binarySearch(root, mid, depth)) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return left; // Return the count of nodes on the last level
    }
}
