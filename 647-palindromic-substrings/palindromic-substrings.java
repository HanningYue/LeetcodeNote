class Solution {
    Boolean[][] dpTable;
    public int countSubstrings(String s) {
        int n = s.length();
        fillTable(s);
        
        int count = 0;
        for (int left = 0; left < n; left++) {
            for (int right = left; right < n; right++) {
                if (dpTable[left][right]) {
                    count++;
                }
            }
        }
        return count;
    }
    private void fillTable(String s) {
        int n = s.length();
        dpTable = new Boolean[n][n];
        for (int i = 0; i < n; i++) {
            dpTable[i][i] = true;
        }

        for (int i = 0; i < n - 1; i++) {
            dpTable[i][i + 1] = s.charAt(i) == s.charAt(i + 1);
        }

        for (int length = 3; length <= n; length++) {
            for (int left = 0; left <= n - length; left++) {
                int right = left + length - 1;
                dpTable[left][right] = s.charAt(left) == s.charAt(right) && dpTable[left + 1][right - 1];
            }
        }
    }
}