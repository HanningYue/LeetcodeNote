class Solution {
    Integer[][] dpTable;
    public int maxCoins(int[] nums) {
        int n = nums.length;
        dpTable = new Integer[n + 2][n + 2];
        
        int[] points = new int[n + 2];
        points[0] = 1;
        points[n + 1] = 1;
        for (int i = 1; i <= n; i++) {
            points[i] = nums[i - 1];
        }
        return dp(points, 0, points.length - 1);
    }
    private int dp(int[] points, int left, int right) {
        if (left + 1 == right) {
            return 0;
        }
        if (dpTable[left][right] != null) {
            return dpTable[left][right];
        }

        int result = 0;
        for (int i = left + 1; i < right; i++) {
            int leftPart = dp(points, left, i);
            int rightPart = dp(points, i, right);
            int current =  points[i] * points[left] * points[right] + leftPart + rightPart;
            result = Math.max(result, current);
        }

        dpTable[left][right] = result;
        return dpTable[left][right];
    } 
}