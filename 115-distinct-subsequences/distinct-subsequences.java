class Solution {
    private int[][] dpTable;
    public int numDistinct(String s, String t) {
        dpTable = new int[s.length()][t.length()];
        for (int[] row : dpTable) {
            Arrays.fill(row, -1);
        }
        return dp(s, 0, t, 0);
    }
    private int dp(String s, int sindex, String t, int tindex) {
        if (tindex == t.length()) {
            return 1;
        }
        if (s.length() - sindex < t.length() - tindex) {
            return 0;
        }
        if (dpTable[sindex][tindex] != -1) {
            return dpTable[sindex][tindex];
        }
        int result = 0;
        if (s.charAt(sindex) == t.charAt(tindex)) {
            result += dp(s, sindex + 1, t, tindex + 1) + dp(s, sindex + 1, t, tindex);
        } else {
            result += dp(s, sindex + 1, t, tindex);
        }
        dpTable[sindex][tindex] = result;
        return result;
    }
}