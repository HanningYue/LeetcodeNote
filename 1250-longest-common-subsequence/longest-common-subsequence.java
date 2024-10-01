class Solution {
    Integer[][] dpTable;
    public int longestCommonSubsequence(String text1, String text2) {
        int n = text1.length(), m = text2.length();
        dpTable = new Integer[n][m];
        return dp(text1, 0, text2, 0);
    }
    private int dp(String text1, int i, String text2, int j) {
        if (i >= text1.length() || j >= text2.length()) {
            return 0;
        }
        if (dpTable[i][j] != null) {
            return dpTable[i][j];
        }
        
        if (text1.charAt(i) == text2.charAt(j)) {
            int use = dp(text1, i + 1, text2, j + 1);
            dpTable[i][j] = use + 1;
        } else {
            int skipI = dp(text1, i + 1, text2, j);
            int skipJ = dp(text1, i, text2, j + 1);
            dpTable[i][j] = Math.max(skipI, skipJ);
        }
        return dpTable[i][j];
    }
}