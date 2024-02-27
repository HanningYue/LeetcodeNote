class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length, n = matrix[0].length;
        
        int left = 0, right = m * n - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (oneToTwo(matrix, mid) == target) {
                return true;
            } else if (oneToTwo(matrix, mid) < target) {
                left = mid + 1;
            } else if (oneToTwo(matrix, mid) > target) {
                right = mid - 1;
            }
        }
        return false;
    }
    private int oneToTwo(int[][] matrix, int midIdx) {
        int colLength = matrix[0].length;
        int row = midIdx / colLength;
        int col = midIdx % colLength;
        return matrix[row][col];
    }
}