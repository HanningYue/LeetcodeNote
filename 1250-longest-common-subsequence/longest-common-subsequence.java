class Solution {
    Integer[][] dpTable;
    public int longestCommonSubsequence(String text1, String text2) {
        int m = text1.length(), n = text2.length();
        dpTable = new Integer[m][n];
        return dp(text1, m - 1, text2, n - 1);
    }
    private int dp(String text1, int i, String text2, int j) {
        if (i == -1 || j == -1) {
            return 0;
        }
        if (dpTable[i][j] != null) {
            return dpTable[i][j];
        }

        if (text1.charAt(i) == text2.charAt(j)) {
            int foundSubsequence = dp(text1, i - 1, text2, j - 1) + 1;
            dpTable[i][j] = foundSubsequence;
        } else {
            int diffInText1 = dp(text1, i - 1, text2, j);
            int diffInText2 = dp(text1, i, text2, j - 1);
            dpTable[i][j] = Math.max(diffInText1, diffInText2);
        }
        return dpTable[i][j];
    }
}