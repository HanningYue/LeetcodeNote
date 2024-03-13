class Solution {
    Boolean[][] dpTable;
    public boolean isInterleave(String s1, String s2, String s3) {
        int m = s1.length(), n = s2.length();
        if (m + n != s3.length()) {
            return false;
        }

        dpTable = new Boolean[m + 1][n + 1];
        return dp(s1, 0, s2, 0, s3, 0);
    }
    private boolean dp(String s1, int i, String s2, int j, String s3, int k) {
        if (k == s3.length()) {
            return true;
        }
        if (dpTable[i][j] != null) {
            return dpTable[i][j];
        }

        if (i < s1.length() && s1.charAt(i) == s3.charAt(k)) {
            dpTable[i][j] = dp(s1, i + 1, s2, j, s3, k + 1);
            if (dpTable[i][j]) {
                return true;
            }
        }
        
        if (j < s2.length() && s2.charAt(j) == s3.charAt(k)) {
            dpTable[i][j] = dp(s1, i, s2, j + 1, s3, k + 1);
            return dpTable[i][j];
        }
        
        // If neither character matches, or both paths return false, set and return false
        dpTable[i][j] = false;
        return false;
    }
}