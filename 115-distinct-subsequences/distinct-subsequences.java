class Solution {     
    Integer[][] dpTable;
    public int numDistinct(String s, String t) {
        int m = s.length(), n = t.length();
        dpTable = new Integer[m][n];
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
            int use = dp(s, i + 1, t, j + 1);
            int notUse = dp(s, i + 1, t, j);
            dpTable[i][j] = use + notUse;
        } else if (s.charAt(i) != t.charAt(j)) {
            int skip = dp(s, i + 1, t, j);
            dpTable[i][j] = skip;
        }
        return dpTable[i][j];
    }
}