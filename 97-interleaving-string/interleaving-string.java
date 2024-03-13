class Solution {
    Boolean[][] dpTable;
    public boolean isInterleave(String s1, String s2, String s3) {
        int m = s1.length(), n = s2.length();
        if (m + n != s3.length()) {
            return false;
        }
        dpTable = new Boolean[m][n];
        return dp(s1, 0, s2, 0, s3, 0);
    }

    private boolean dp(String s1, int i, String s2, int j, String s3, int k) {
        if (k == s3.length()) {
            return true;
        }
        if (i < s1.length() && j < s2.length() && dpTable[i][j] != null) {
            return dpTable[i][j];
        }

        boolean valid = false;
        if (i < s1.length() && s1.charAt(i) == s3.charAt(k)) {
            valid = dp(s1, i + 1, s2, j, s3, k + 1);
        }
        if (!valid && j < s2.length() && s2.charAt(j) == s3.charAt(k)) {
            valid = dp(s1, i, s2, j + 1, s3, k + 1);
        }
        
        if (i < s1.length() && j < s2.length()) {
            dpTable[i][j] = valid;
        }
        return valid;
    }
}
