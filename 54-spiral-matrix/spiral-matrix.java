class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        int m = matrix.length, n = matrix[0].length;
        int totalElements = m * n;
        List<Integer> result = new ArrayList<>();
        
        int top = 0, bottom = m - 1, left = 0, right = n - 1;
        while (result.size() < totalElements) {
            if (top <= bottom) {
                for (int col = left; col <= right; col++) {
                    result.add(matrix[top][col]);
                }
                top++;
            }
            if (left <= right) {
                for (int row = top; row <= bottom; row++) {
                    result.add(matrix[row][right]);
                }
                right--;
            }
            if (top <= bottom) {
                for (int col = right; col >= left; col--) {
                    result.add(matrix[bottom][col]);
                }
                bottom--;
            }
            if (left <= right) {
                for (int row = bottom; row >= top; row--) {
                    result.add(matrix[row][left]);
                }
                left++;
            }
        }
        return result;
    }
}