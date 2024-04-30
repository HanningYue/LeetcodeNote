class Solution {
    Integer[][] dpTable;
    public int minDistance(String word1, String word2) {
        int m = word1.length(), n = word2.length();
        dpTable = new Integer[m][n];
        return dp(word1, m - 1, word2, n - 1);
    }
    private int dp(String s, int i, String t, int j) {
        if (i == -1) {
            return j + 1;
        } else if (j == -1) {
            return i + 1;
        }

        if (dpTable[i][j] != null) {
            return dpTable[i][j];
        }

        if (s.charAt(i) == t.charAt(j)) {
            int skip = dp(s, i - 1, t, j - 1);
            dpTable[i][j] = skip;
        } else if (s.charAt(i) != t.charAt(j)) {
            int replace = dp(s, i - 1, t, j - 1);
            int insert = dp(s, i, t, j - 1);
            int delete = dp(s, i - 1, t, j);
            dpTable[i][j] = Math.min(delete, Math.min(replace, insert)) + 1;
        }
        return dpTable[i][j];
    }
}