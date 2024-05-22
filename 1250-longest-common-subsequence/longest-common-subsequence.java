class Solution {
    Integer[][] dpTable;
    public int longestCommonSubsequence(String text1, String text2) {
        int m = text1.length(), n = text2.length();
        dpTable = new Integer[m][n];
        return dp(text1, m - 1, text2, n - 1);
    }
    private int dp(String text1, int i, String text2, int j) {
        if (i == -1) {
            return 0;
        } else if (j == -1) {
            return 0;
        }
        if (dpTable[i][j] != null) {
            return dpTable[i][j];
        }
        if (text1.charAt(i) == text2.charAt(j)) {
            int skipBoth = dp(text1, i - 1, text2, j - 1);
            dpTable[i][j] = skipBoth + 1;
        } else {
            int skipI = dp(text1, i - 1, text2, j);
            int skipJ = dp(text1, i, text2, j - 1);
            dpTable[i][j] = Math.max(skipI, skipJ);
        }
        return dpTable[i][j];
    }
}