class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length, n = matrix[0].length;

        int left = 0, right = m * n - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            int value = helper(matrix, mid);
            if (value == target) {
                return true;
            } else if (value < target) {
                left = mid + 1;
            } else if (value > target) {
                right = mid - 1;
            }
        }
        return false;
    }
    private int helper(int[][] matrix, int index) {
        int row = index / matrix[0].length;
        int col = index % matrix[0].length;
        return matrix[row][col];
    }
}