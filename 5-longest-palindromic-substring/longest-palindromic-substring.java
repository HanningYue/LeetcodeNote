class Solution {
    Boolean[][] dpTable;
    public String longestPalindrome(String s) {
        dp(s);
        
        int start = 0, maxLength = 1;
        for (int left = 0; left < s.length(); left++) {
            for (int right = left; right < s.length(); right++) {
                if (dpTable[left][right] && maxLength < (right - left + 1)) {
                    maxLength = right - left + 1;
                    start = left;
                }
            }
        }
        return s.substring(start, start + maxLength);
    }

    private void dp(String s) {
        int n = s.length();
        dpTable = new Boolean[n][n];
        for (int i = 0; i < n; i++) {
            dpTable[i][i] = true;
        }
        
        for (int i = 0; i < n - 1; i++) {
            boolean palindrome = s.charAt(i) == s.charAt(i + 1);
            dpTable[i][i + 1] = palindrome;
        }

        for (int length = 3; length <= n; length++) {
            for (int left = 0; left <= n - length; left++) {
                int right = left + length - 1;
                boolean palindrome = s.charAt(left) == s.charAt(right);
                dpTable[left][right] = palindrome && dpTable[left + 1][right - 1];
            }
        }
    }
}
