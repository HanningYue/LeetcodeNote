/*
1. 向右要右边最深的path 向左要左边最深的path
2. 每层+1， 加上当前的level， 返回最大的path
*/
class Solution {
    public int maxDepth(TreeNode root) {
        if (root == null) return 0;
        int left = maxDepth(root.left);
        int right = maxDepth(root.right);
        int current = Math.max(left, right) + 1;
        return current;
    }
}