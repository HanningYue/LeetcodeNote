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

        int total = 0;
        if (index + 1 < s.length()) {
            int twoDigits = Integer.parseInt(s.substring(index, index + 2));
            if (twoDigits <= 26) {
                int countUsingTwo = dp(s, index + 2);
                total += countUsingTwo;
            }
        }
        int countUsingOne = dp(s, index + 1);
        total += countUsingOne;
        
        dpTable[index] = total;
        return dpTable[index];
    }
}