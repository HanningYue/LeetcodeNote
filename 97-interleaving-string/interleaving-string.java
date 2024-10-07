class Solution {
    Boolean[][] dpTable;
    public boolean isInterleave(String s1, String s2, String s3) {
        int m = s1.length(), n = s2.length(), l = s3.length();
        if (m + n != l) {
            return false;
        }

        dpTable = new Boolean[m + 1][n + 1];
        return dp(s1, 0, s2, 0, s3, 0);
    }
    private boolean dp(String s1, int i, String s2, int j, String s3, int k) {
        if (k == s3.length()) {
            return true;
        }
        if (s3.length() - k > (s1.length() - i + s2.length() - j)) {
            return false;
        }
        if (dpTable[i][j] != null) {
            return dpTable[i][j];
        }
        
        if (i < s1.length() && s1.charAt(i) == s3.charAt(k) && j < s2.length() && s2.charAt(j) == s3.charAt(k)) {
            boolean skipI = dp(s1, i + 1, s2, j, s3, k + 1);
            boolean skipJ = dp(s1, i, s2, j + 1, s3, k + 1);
            dpTable[i][j] = skipI || skipJ;
        } else if (i < s1.length() && s1.charAt(i) == s3.charAt(k)) {
            boolean skipI = dp(s1, i + 1, s2, j, s3, k + 1);
            dpTable[i][j] = skipI;
        } else if (j < s2.length() && s2.charAt(j) == s3.charAt(k)) {
            boolean skipJ = dp(s1, i, s2, j + 1, s3, k + 1);
            dpTable[i][j] = skipJ;
        } else {
            dpTable[i][j] = false;
        }

        return dpTable[i][j];
    }
}