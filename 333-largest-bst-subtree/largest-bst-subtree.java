class Solution {
	class Type {
        boolean isBST;
        int min, max, size;
        public Type (int min, int max, int size, boolean isBST) {
            this.min = min;
            this.max = max;
            this.size = size;
            this.isBST = isBST;
        }
    }
    int maxSize;
	public int largestBSTSubtree(TreeNode root) {
        int[] count = {0};
        dfs(root);
        return maxSize;
    }

    private Type dfs(TreeNode root) {
        if (root == null) return new Type(Integer.MAX_VALUE, Integer.MIN_VALUE, 0, true);
        
        Type left = dfs(root.left);
        Type right = dfs(root.right);

        boolean isBST = left.isBST && right.isBST && ((root.val > left.max) && (root.val < right.min));

        int size = left.size + right.size + 1;

        int min = Math.min(Math.min(left.min, right.min), root.val);
        int max = Math.max(Math.max(left.max, right.max), root.val);
        if (isBST) {
            maxSize = Math.max(maxSize, size);
        }

        return new Type(min, max, size, isBST);
    }
}