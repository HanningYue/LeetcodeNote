class Solution {
    Boolean[][] dpTable;
    public boolean isMatch(String s, String p) {
        int m = s.length(), n = p.length();
        dpTable = new Boolean[m][n];
        return dp(s, 0, p, 0);
    }
    private boolean dp(String s, int i, String p, int j) {
        if (j == p.length()) {
            return i == s.length();
        }
        if (i == s.length()) {
            if ((p.length() - j) % 2 != 0) {
                return false;
            }
            for (; j + 1 < p.length(); j += 2) {
                if (p.charAt(j + 1) != '*') {
                    return false;
                }
            }
            return true;
        }

        if (dpTable[i][j] != null) {
            return dpTable[i][j];
        }

        boolean result = false;
        if (s.charAt(i) == p.charAt(j) || p.charAt(j) == '.') {
            if (j + 1 < p.length() && p.charAt(j + 1) == '*') {
                result = dp(s, i, p, j + 2) || dp(s, i + 1, p, j);
            } else {
                result = dp(s, i + 1, p, j + 1);
            }
        }
        else {
            if (j + 1 < p.length() && p.charAt(j + 1) == '*') {
                result = dp(s, i, p, j + 2);
            } else {
                return false;
            }
        }
        dpTable[i][j] = result;
        return dpTable[i][j];
    }
}