class Solution {
    public int maximumWealth(int[][] accounts) {
        int richest = Integer.MIN_VALUE;
        for (int[] customer : accounts) {
            int money = 0;
            for (int account : customer) {
                money += account;
            }
            richest = Math.max(richest, money);
        }
        return richest;
    }
}