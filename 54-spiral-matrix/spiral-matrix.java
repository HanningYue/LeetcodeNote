class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> result = new ArrayList<>();
        int m = matrix.length;
        int n = matrix[0].length;
        
        int topRow = 0, bottomRow = m - 1;
        int leftCol = 0, rightCol = n - 1;
        while (result.size() < m * n) {
            if (topRow <= bottomRow) {
                for (int col = leftCol; col <= rightCol; col++) {
                    result.add(matrix[topRow][col]);
                }
                topRow++;
            }
            if (leftCol <= rightCol) {
                for (int row = topRow; row <= bottomRow; row++) {
                    result.add(matrix[row][rightCol]);
                }
                rightCol--;
            }
            if (topRow <= bottomRow) {
                for (int col = rightCol; col >= leftCol; col--) {
                    result.add(matrix[bottomRow][col]);
                }
                bottomRow--;
            }
            if (leftCol <= rightCol) {
                for (int row = bottomRow; row >= topRow; row--) {
                    result.add(matrix[row][leftCol]);
                }
                leftCol++;
            }
        }
        return result;
    }
}