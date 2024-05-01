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
            int skip = dp(word1, i - 1, word2, j - 1);
            dpTable[i][j] = skip;
        } else {
            int replace = dp(word1, i - 1, word2, j - 1);
            int delete = dp(word1, i - 1, word2, j);
            int insert = dp(word1, i, word2, j - 1);
            dpTable[i][j] = Math.min(replace, Math.min(delete, insert)) + 1;
        }
        return dpTable[i][j];
    }
}