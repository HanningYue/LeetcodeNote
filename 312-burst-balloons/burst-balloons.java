class Solution {
    Integer[][] dpTable;
    public int maxCoins(int[] nums) {
        int n = nums.length;
        dpTable = new Integer[n + 2][n + 2];
        int[] points = new int[n + 2];
        points[0] = points[n + 1] = 1;
        for (int i = 1; i <= n; i++) {
            points[i] = nums[i - 1];
        }

        return dp(0, n + 1, points);
    }
    private int dp(int left, int right, int[] points) {
        if (left + 1 == right) {
            return 0;
        }
        if (dpTable[left][right] != null) {
            return dpTable[left][right];
        }

        int maxPoint = 0;
        for (int i = left + 1; i < right; i++) {
            int currentPoint = dp(left, i, points) + dp(i, right, points) 
            + points[left] * points[right] * points[i];
            maxPoint = Math.max(maxPoint, currentPoint);
        }
        dpTable[left][right] = maxPoint;
        return dpTable[left][right];
    }
}