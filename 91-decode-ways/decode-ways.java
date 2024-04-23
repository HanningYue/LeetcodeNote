class Solution {
    Integer[] dpTable;
    public int numDecodings(String s) {
        int n = s.length();
        dpTable = new Integer[n];
        return dp(s, 0);
    }

    private int dp(String s, int index) {
        if (index == s.length()) {
            return 1;
        }

        if (s.charAt(index) == '0') {
            return 0;
        }
        
        if (dpTable[index] != null) {
            return dpTable[index];
        }

        int count = dp(s, index + 1);
        if (index < s.length() - 1) {
            int twoDigits = (s.charAt(index) - '0') * 10 + (s.charAt(index + 1) - '0');
            if (twoDigits >= 10 && twoDigits <= 26) {
                count += dp(s, index + 2);
            }
        }

        dpTable[index] = count;
        return count;
    }
}
