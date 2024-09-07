class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length, n = matrix[0].length;
        int totalIndex = m * n - 1;
        int left = 0, right = totalIndex;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            int twoDIndex = oneDtoTwo(matrix, mid);
            if (twoDIndex == target) {
                return true;
            } else if (twoDIndex < target) {
                left = mid + 1;
            } else if (twoDIndex > target) {
                right = mid - 1;
            }
        }
        return false;
    }
    private int oneDtoTwo(int[][] matrix, int pivot) {
        int col = matrix[0].length;
        int rowIndex = pivot / col;
        int colIndex = pivot % col;
        return matrix[rowIndex][colIndex];
    }
}