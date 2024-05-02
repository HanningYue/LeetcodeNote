class Solution {
    Integer[][] dpTable;
    public int change(int amount, int[] coins) {
        dpTable = new Integer[coins.length][amount + 1];
        return dp(amount, coins, 0);
    }
    private int dp(int amount, int[] coins, int index) {
        if (amount < 0 || index == coins.length) {
            return 0;
        }
        if (amount == 0) {
            return 1;
        }
        if (dpTable[index][amount] != null) {
            return dpTable[index][amount];
        }
        int useCurrent = dp(amount - coins[index], coins, index);
        int skipCurrent = dp(amount, coins, index + 1);
        dpTable[index][amount] = useCurrent + skipCurrent;
        return dpTable[index][amount];
    }
}