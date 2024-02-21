class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> result = new ArrayList<>();
        int m = matrix.length, n = matrix[0].length;
        int totalElement = m * n;
        int up = 0, down = m - 1, left = 0, right = n - 1;

        while (result.size() < totalElement) {
            if (up <= down) {
                for (int i = left; i <= right; i++) {
                    result.add(matrix[up][i]);
                }
                up++;
            }

            if (left <= right) {
                for (int i = up; i <= down; i++) {
                    result.add(matrix[i][right]);
                }
                right--;
            }

            if (up <= down) { 
                for (int i = right; i >= left; i--) {
                    result.add(matrix[down][i]);
                }
                down--;
            }

            if (left <= right) {
                for (int i = down; i >= up; i--) {
                    result.add(matrix[i][left]);
                }
                left++;
            }
        }
        return result;
    }
}