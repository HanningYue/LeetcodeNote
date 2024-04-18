class Solution {
    Integer[] dpTable;
    public int fib(int n) {
        dpTable = new Integer[n + 1];
        return dp(n);
    }

    private int dp(int n) {
        if (n == 0) {
            return 0;
        } else if (n <= 2) {
            return 1;
        }
        
        if (dpTable[n] != null) {
            return dpTable[n];
        }
        int minusOne = dp(n - 1);
        int minusTwo = dp(n - 2);
        dpTable[n] = minusOne + minusTwo;
        return dpTable[n];
    }
}