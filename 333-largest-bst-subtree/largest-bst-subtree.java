class Solution {
    class Type {
        int min;
        int max;
        boolean isBST;
        int size;
        public Type(int min, int max, boolean isBST, int size) {
            this.min = min;
            this.max = max;
            this.isBST = isBST;
            this.size = size;
        }
    }
    private int maxSize;
    public int largestBSTSubtree(TreeNode root) {
        dfs(root);
        return maxSize;
    }
    private Type dfs(TreeNode root) {
        if (root == null) {
            return new Type(Integer.MAX_VALUE, Integer.MIN_VALUE, true, 0);
        }
        
        Type left = dfs(root.left);
        Type right = dfs(root.right);

        int min = Math.min(root.val, Math.min(left.min, right.min));
        int max = Math.max(root.val, Math.max(left.max, right.max));
        boolean isBST = left.isBST && right.isBST && ((root.val > left.max) && (root.val < right.min));
        int size = left.size + right.size + 1;

        if (isBST) {
            maxSize = Math.max(maxSize, size);
        }

        return new Type(min, max, isBST, size);
    }
}