class Solution {
    Boolean[][] dpTable;
    public int countSubstrings(String s) {
        dp(s);
        int count = 0;
        for (int left = 0; left < s.length(); left++) {
            for (int right = left; right < s.length(); right++) {
                if (dpTable[left][right]) {
                    count++;
                }
            }
        }        
        return count;
    }
    private void dp(String s) {
        int n = s.length();
        dpTable = new Boolean[n][n];
        for (int i = 0; i < n; i++) {
            dpTable[i][i] = true;
        }

        for (int i = 0; i < n - 1; i++) {
            boolean adjacent = s.charAt(i) == s.charAt(i + 1);
            dpTable[i][i + 1] = adjacent;
        }

        for (int length = 3; length <= n; length++) {
            for (int left = 0; left <= n - length; left++) {
                int right = left + length - 1;
                dpTable[left][right] = s.charAt(left) == s.charAt(right) && dpTable[left + 1][right - 1];
            }
        }
    }
}