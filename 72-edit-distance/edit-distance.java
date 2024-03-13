class Solution {
    int[][] dpTable;
    public int minDistance(String word1, String word2) {
        int m = word1.length(), n = word2.length();
        dpTable = new int[m + 1][n + 1];
        for (int i = 1; i <= m; i++) {
            dpTable[i][0] = i;
        }
        for (int j = 1; j <= n; j++) {
            dpTable[0][j] = j;
        }
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    dpTable[i][j] = dpTable[i - 1][j - 1];
                } else {
                    dpTable[i][j] = findMin(dpTable[i - 1][j] + 1, dpTable[i][j - 1] + 1, dpTable[i - 1][j - 1] + 1);
                }
            }
        }
        return dpTable[m][n];
    }
    private int findMin(int a, int b, int c) {
        return Math.min(a, Math.min(b, c));
    }
}