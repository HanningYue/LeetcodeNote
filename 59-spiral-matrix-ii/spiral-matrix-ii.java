class Solution {
    public int[][] generateMatrix(int n) {
        int[][] result = new int[n][n];
        int up = 0, down = n - 1;
        int left = 0, right = n - 1;
        int num = 1;
        while (num <= n * n) {
            if (up <= down) {
                for (int i = left; i <= right; i++) {
                    result[up][i] = num++;
                }
                up++;
            }
            if (left <= right) {
                for (int i = up; i <= down; i++) {
                    result[i][right] = num++;
                }
                right--;
            }
            if (up <= down) {
                for (int i = right; i >= left; i--) {
                    result[down][i] = num++;
                }
                down--;
            }
            if (left <= right) {
                for (int i = down; i >= up; i--) {
                    result[i][left] = num++;
                }
                left++;
            }
        }
        return result;
    }
}