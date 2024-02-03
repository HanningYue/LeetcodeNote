class Solution {
    public int kthSmallest(int[][] matrix, int k) {
        int left = matrix[0][0];
        int right = matrix[matrix.length - 1][matrix.length - 1];
        while (left <= right) {
            int mid = left + (right - left) / 2;
            int count = countSearch(matrix, mid);
            if (count < k) {
                left = mid + 1;
            } else if (count > k) {
                right = mid - 1;
            } else if (count == k) {
                right = mid - 1;
            }
        }
        return left;
    }

    private int countSearch(int[][] matrix, int target) {
        int count = 0;
        int row = matrix.length - 1, col = 0;
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