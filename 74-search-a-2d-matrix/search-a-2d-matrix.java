class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length, n = matrix[0].length;
        int endIdx = m * n - 1;
        int start = 0, end = endIdx;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            int midValue = helper(matrix, mid);
            if (midValue == target) {
                return true;
            } else if (midValue < target) {
                start = mid + 1;;
            } else if (midValue > target) {
                end = mid - 1;
            }
        }
        return false;
    }
    private int helper(int[][] matrix, int midIdx) {
        int colLength = matrix[0].length;
        int rowIdx = midIdx / colLength;
        int colIdx = midIdx % colLength;
        return matrix[rowIdx][colIdx];
    }
}