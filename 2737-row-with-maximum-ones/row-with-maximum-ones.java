class Solution {
    public int[] rowAndMaximumOnes(int[][] mat) {
        int maxOne = 0, maxOneIdx = 0;
        for (int i = 0; i < mat.length; i++) {
            int localOne = 0;
            for (int j = 0; j < mat[i].length; j++) {
                if (mat[i][j] == 1) {
                    localOne++;
                }
            }
            if (localOne > maxOne) {
                maxOne = localOne;
                maxOneIdx = i;
            }
        }
        return new int[]{maxOneIdx, maxOne};
    }
}