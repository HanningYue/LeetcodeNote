class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> result = new ArrayList<>();
        int m = matrix.length, n = matrix[0].length;
        int totalElements = m * n;
        
        int topRow = 0, bottomRow = m - 1;
        int leftCol = 0, rightCol = n - 1;
        while (result.size() < totalElements) {
            if (topRow <= bottomRow) {
                for (int i = leftCol; i <= rightCol; i++) {
                    result.add(matrix[topRow][i]);
                }
                topRow++;
            }
            if (leftCol <= rightCol) {
                for (int i = topRow; i <= bottomRow; i++) {
                    result.add(matrix[i][rightCol]);
                }
                rightCol--;
            }
            if (topRow <= bottomRow) {
                for (int i = rightCol; i >= leftCol; i--) {
                    result.add(matrix[bottomRow][i]);
                }
                bottomRow--;
            }
            if (leftCol <= rightCol) {
                for (int i = bottomRow; i >= topRow; i--) {
                    result.add(matrix[i][leftCol]);
                }
                leftCol++;
            }
        }
        return result;
    }
}