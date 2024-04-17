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
        return dp(points, 0, n + 1);
    }
    private int dp(int[] points, int left, int right) {
        if (left + 1 == right) {
            return 0;
        }
        if (dpTable[left][right] != null) {
            return dpTable[left][right];
        }

        int maxPoint = 0;
        for (int i = left + 1; i < right; i++) {
            int leftPart = dp(points, left, i);
            int rightPart = dp(points, i, right);
            int currentPoint = leftPart + rightPart + points[left] * points[i] * points[right];

            maxPoint = Math.max(maxPoint, currentPoint);
        }
        dpTable[left][right] = maxPoint;
        return dpTable[left][right];
    }
}