class Solution {
    public int[][] generateMatrix(int n) {
        int[][] result = new int[n][n];
        int num = 1;
        int up = 0, low = n - 1;
        int left = 0, right = n - 1;
        while (num <= n * n) {
            if (up <= low) {
                for (int i = left; i <= right; i++) {
                    result[up][i] = num++;
                }
                up++;
            }
            if (left <= right) {
                for (int i = up; i <= low; i++) {
                    result[i][right] = num++;
                }
                right--;
            }
            if (up <= low) {
                for (int i = right; i >= left; i--) {
                    result[low][i] = num++;
                }
                low--;
            }
            if (left <= right) {
                for (int i = low; i >= up; i--) {
                    result[i][left] = num++;
                }
                left++;
            }
        }
        return result;
    }
}