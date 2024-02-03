class Solution {
    public int kthSmallest(int[][] matrix, int k) {
        int left = matrix[0][0], right = matrix[matrix.length - 1][matrix.length - 1];
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (countLessThanK(matrix, mid) < k) {
                left = mid + 1;
            } else if (countLessThanK(matrix, mid) > k) {
                right = mid - 1;
            } else if (countLessThanK(matrix, mid) == k) {
                right = mid - 1;
            }
        }
        return left;
    }
    private int countLessThanK(int[][] matrix, int target) {
        int row = matrix.length - 1;;
        int col = 0;
        int count = 0;
        while (col < matrix.length && row >= 0) {
            if (matrix[row][col] <= target) {
                count += row + 1;
                col++;
            } else if (matrix[row][col] > target) {
                row--;
            }
        }
        return count;
    }
}