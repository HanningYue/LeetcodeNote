class Solution {
    int[][] dpTable;
    public boolean isInterleave(String s1, String s2, String s3) {
        int m = s1.length(), n = s2.length();
        if (m + n != s3.length()) {
            return false;
        }
        dpTable = new int[m + 1][n + 1];
        for (int i = 0; i < dpTable.length; i++) {
            Arrays.fill(dpTable[i], -1);
        }
        return dp(s1, 0, s2, 0, s3);
    }
    private boolean dp(String s1, int i, String s2, int j, String s3) {
        int k = i + j;
        if (k == s3.length()) {
            return true;
        }
        if (dpTable[i][j] != -1) {
            return dpTable[i][j] == 1 ? true : false;
        }
        boolean result = false;
        if (i < s1.length() && s1.charAt(i) == s3.charAt(k)) {
            result = dp(s1, i + 1, s2, j, s3);
        }
        if (j < s2.length() && s2.charAt(j) == s3.charAt(k)) {
            result = result || dp(s1, i, s2, j + 1, s3);
        }
        dpTable[i][j] = result == true ? 1 : 0;
        return result;
    }
}