class Solution {
    Integer[][] dpTable;
    public int minDistance(String word1, String word2) {
        int m = word1.length(), n = word2.length();
        dpTable = new Integer[m][n];
        return dp(word1, m - 1, word2, n - 1);
    }

    private int dp(String s1, int i, String s2, int j) {
        if (i == -1) {
            return j + 1;
        }
        if (j == -1) {
            return i + 1;
        }
        if (dpTable[i][j] != null) {
            return dpTable[i][j];
        }
        
        int skip = dp(s1, i - 1, s2, j - 1);
        int insert = dp(s1, i, s2, j - 1) + 1;
        int delete = dp(s1, i - 1, s2, j) + 1;
        int replace = dp(s1, i - 1, s2, j - 1) + 1;

        if (s1.charAt(i) == s2.charAt(j)) {
            dpTable[i][j] = skip;
        } 
        else if (s1.charAt(i) != s2.charAt(j)){
            dpTable[i][j]
            = Math.min(insert, Math.min(delete, replace));
        }
        return dpTable[i][j];
    }
}