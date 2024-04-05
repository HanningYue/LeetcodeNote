class Solution {
    Integer[][] dpTable;
    public int minDistance(String word1, String word2) {
        int m = word1.length(), n = word2.length();
        dpTable = new Integer[m][n];
        return dp(word1, m - 1, word2, n - 1);
    }
    private int dp(String word1, int i, String word2, int j) {
        if (i == -1) {
            return j + 1;
        } else if (j == -1) {
            return i + 1;
        }

        if (dpTable[i][j] != null) {
            return dpTable[i][j];
        }
        if (word1.charAt(i) == word2.charAt(j)) {
            dpTable[i][j] = dp(word1, i - 1, word2, j - 1);
        } else {
            int skipI = dp(word1, i - 1, word2, j) + 1;
            int skipJ = dp(word1, i, word2, j - 1) + 1;
            int skipBoth = dp(word1, i - 1, word2, j - 1) + 1;
            dpTable[i][j] = Math.min(skipI, Math.min(skipJ, skipBoth));
        }
        return dpTable[i][j];
    }
}