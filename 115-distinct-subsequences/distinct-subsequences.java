class Solution {
    int[][] dpTable;
    public int numDistinct(String s, String t) {
        dpTable = new int[s.length()][t.length()];
        for (int[] row : dpTable) {
            Arrays.fill(row, -1);
        }
        return dp(s, 0, t, 0);
    }
    
    // 定义：s[i..] 的子序列中 t[j..] 出现的次数为 dp(s, i, t, j)
    private int dp(String s, int i, String t, int j) {
        if (j == t.length()) {
            return 1;
        }
        if (s.length() - i < t.length() - j) {
            return 0;
        }
        
        if (dpTable[i][j] != -1) {
            return dpTable[i][j];
        }

        int result = 0;
        if (s.charAt(i) == t.charAt(j)) {
            result += dp(s, i + 1, t, j + 1) + dp(s, i + 1, t, j);
        }
        else {
            result += dp(s, i + 1, t, j);
        }
        dpTable[i][j] = result;
        return result;
    }
}