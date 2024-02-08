//dpTable array represents, if we use i coins, when the amount is j, 
//we have dpTable[i][j] number of ways to achieve amount
class Solution {
    public int change(int amount, int[] coins) {
        int[][] dpTable = new int[coins.length + 1][amount + 1];
        for (int i = 0; i <= coins.length; i++) {
            dpTable[i][0] = 1;
        }
        for (int i = 1; i <= coins.length; i++) {
            for (int j = 1; j <= amount; j++) {
                int currentCoin = coins[i - 1];
                if (j - currentCoin < 0) {
                    dpTable[i][j] = dpTable[i - 1][j];
                } else {
                    dpTable[i][j] = dpTable[i - 1][j] + dpTable[i][j - currentCoin];
                }
            }
        }
        return dpTable[coins.length][amount];
    }
}