class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int n = matrix.length, m = matrix[0].length;
        
        int left = 0, right = n * m - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (oneDtoTwoD(matrix, mid) == target) {
                return true;
            } else if (oneDtoTwoD(matrix, mid) < target) {
                left = mid + 1;
            } else if (oneDtoTwoD(matrix, mid) > target) {
                right = mid - 1;
            }
        }
        return false;
    }
    private int oneDtoTwoD(int[][] matrix, int index) {
        int length = matrix[0].length;
        int row = index / length;
        int col = index % length;
        return matrix[row][col];
    }
}