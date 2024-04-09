class Solution {
    Integer[][] dpTable;
    public int longestCommonSubsequence(String text1, String text2) {
        dpTable = new Integer[text1.length()][text2.length()];
        return dp(text1, text1.length() - 1, text2, text2.length() - 1);
    }
    private int dp(String text1, int i, String text2, int j) {
        if (i == -1 || j == -1) {
            return 0;
        }
        if (dpTable[i][j] != null) {
            return dpTable[i][j];
        }

        if (text1.charAt(i) == text2.charAt(j)) {
            int found = dp(text1, i - 1, text2, j - 1) + 1;
            dpTable[i][j] = found;
        } else {
            int skipI = dp(text1, i - 1, text2, j);
            int skipJ = dp(text1, i, text2, j - 1);
            dpTable[i][j] = Math.max(skipI, skipJ);
        }
        return dpTable[i][j];
    }
}