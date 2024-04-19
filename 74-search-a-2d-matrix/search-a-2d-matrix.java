class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length, n = matrix[0].length;
        int right = m * n - 1;
        int left = 0;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (toTwoD(matrix, mid) == target) {
                return true;
            } else if (toTwoD(matrix, mid) < target) {
                left = mid + 1;
            } else if (toTwoD(matrix, mid) > target) {
                right = mid - 1;
            }
        }
        return false;
    }
    private int toTwoD(int[][] matrix, int index) {
        int n = matrix[0].length;
        int row = index / n;
        int col = index % n;
        return matrix[row][col];
    }
}