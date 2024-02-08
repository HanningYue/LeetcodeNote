class Solution {
    private int[][] dpTable;
    public int minDistance(String word1, String word2) {
        dpTable = new int[word1.length()][word2.length()];
        for (int[] row : dpTable) {
            Arrays.fill(row, -1);
        }
        return dp(word1, word1.length() - 1, word2, word2.length() - 1);
    }
    private int dp(String s1, int i, String s2, int j) {
        if (i == -1) {
            return j + 1;
        }
        if (j == -1) {
            return i + 1;
        }

        if (dpTable[i][j] != -1) {
            return dpTable[i][j];
        }
        if (s1.charAt(i) == s2.charAt(j)) {
            dpTable[i][j] = dp(s1, i - 1, s2, j - 1);
        } else {
            dpTable[i][j] 
            = min(
                dp(s1, i - 1, s2, j) + 1,
                dp(s1, i - 1, s2, j - 1) + 1,
                dp(s1, i, s2, j - 1) + 1
                );
        }
        return dpTable[i][j];
    }
    private int min(int a, int b, int c) {
        return Math.min(Math.min(a, b), c);
    }
}