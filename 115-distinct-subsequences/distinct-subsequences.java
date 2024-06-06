class Solution {
    Integer[][] dpTable;
    public int numDistinct(String s, String t) {
        dpTable = new Integer[s.length()][t.length()];
        return dp(s, 0, t, 0);
    }
    private int dp(String s, int i, String t, int j) {
        if (j == t.length()) {
            return 1;
        }
        if (t.length() - j > s.length() - i) {
            return 0;
        }
        if (dpTable[i][j] != null) {
            return dpTable[i][j];
        }

        if (s.charAt(i) == t.charAt(j)) {
            int useCurrent = dp(s, i + 1, t, j + 1);
            int notUseCurrent = dp(s, i + 1, t, j);
            dpTable[i][j] = useCurrent + notUseCurrent;
        } else {
            int skipCurrent = dp(s, i + 1, t, j);
            dpTable[i][j] = skipCurrent;
        }
        return dpTable[i][j];
    }
}