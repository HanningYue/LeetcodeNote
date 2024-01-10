class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length, n = matrix[0].length;
        int start = 0, end = m * n - 1;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (oneDToTwoD(matrix, mid) == target) {
                return true;
            } else if (oneDToTwoD(matrix, mid) < target) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return false;
    }
    private int oneDToTwoD (int[][] matrix, int index) {
        int m = matrix.length, n = matrix[0].length;
        int row = index / n, col = index % n;
        return matrix[row][col];
    }
}