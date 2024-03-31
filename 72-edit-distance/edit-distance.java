class Solution {
    Integer[][] dpTable;
    public int minDistance(String word1, String word2) {
        dpTable = new Integer[word1.length()][word2.length()];
        return dp(word1, word1.length() - 1, word2, word2.length() - 1);
    }
    private int dp(String word1, int i, String word2, int j) {
        if (i == -1) {
            return j + 1;
        }
        if (j == -1) {
            return i + 1;
        }
        if (dpTable[i][j] != null) {
            return dpTable[i][j];
        }

        int skip = dp(word1, i - 1, word2, j - 1);
        int replace = dp(word1, i - 1, word2, j - 1) + 1;
        int insert = dp(word1, i, word2, j - 1) + 1;
        int delete = dp(word1, i - 1, word2, j) + 1;
        if (word1.charAt(i) == word2.charAt(j)) {
            dpTable[i][j] = skip;
        } else if (word1.charAt(i) != word2.charAt(j)) {
            dpTable[i][j] = Math.min(replace, Math.min(insert, delete));
        }
        return dpTable[i][j];
    }
}