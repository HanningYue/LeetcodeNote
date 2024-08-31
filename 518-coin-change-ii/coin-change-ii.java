class Solution {
    Integer[][] dpTable;
    public int change(int amount, int[] coins) {
        dpTable = new Integer[coins.length][amount + 1];
        return dp(amount, 0, coins);
    }
    private int dp(int amount, int index, int[] coins) {
        if (index == coins.length || amount < 0) {
            return 0;
        }
        if (amount == 0) {
            return 1;
        }
        
        if (dpTable[index][amount] != null) {
            return dpTable[index][amount];
        }
        int useCurrent = dp(amount - coins[index], index, coins);
        int skipCurrent = dp(amount, index + 1, coins);
        dpTable[index][amount] = useCurrent + skipCurrent;
        return dpTable[index][amount];
    }
}