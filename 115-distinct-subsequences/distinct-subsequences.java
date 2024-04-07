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

        int result = 0;
        if (s.charAt(i) == t.charAt(j)) {
            int skipBoth = dp(s, i + 1, t, j + 1);
            int skipI = dp(s, i + 1, t, j);
            result += skipBoth + skipI;
        } else {
            int skipI = dp(s, i + 1, t, j);
            result += skipI;            
        }
        dpTable[i][j] = result;
        return dpTable[i][j];
    }
}