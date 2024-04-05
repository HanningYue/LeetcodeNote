class Solution {
    Integer[][] dpTable;
    public int longestCommonSubsequence(String text1, String text2) {
        int m = text1.length(), n = text2.length();
        dpTable = new Integer[m][n];
        return dp(text1, m - 1, text2, n - 1);
    }
    private int dp(String s, int i, String t, int j) {
        if (i < 0 || j < 0) {
            return 0;
        }
        if (dpTable[i][j] != null) {
            return dpTable[i][j];
        }
        if (s.charAt(i) == t.charAt(j)) {
            int skipBoth = dp(s, i - 1, t, j - 1);
            dpTable[i][j] = skipBoth + 1;
        } else {
            int skipS = dp(s, i - 1, t, j);
            int skipT = dp(s, i, t, j - 1);
            dpTable[i][j] = Math.max(skipS, skipT);
        }
        return dpTable[i][j];
    }
}