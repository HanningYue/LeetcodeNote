class Solution {
    int[] dpTable;
    public int[] countBits(int n) {
        dpTable = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            dpTable[i] = dpTable[i & (i - 1)] + 1;
        }
        return dpTable;
    }
}