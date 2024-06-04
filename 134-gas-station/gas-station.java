class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int minSum = 0, sum = 0;
        int startIndex = 0;
        for (int i = 0; i < gas.length; i++) {
            sum += gas[i] - cost[i];
            if (sum < minSum) {
                minSum = sum;
                startIndex = i + 1;
            }
        }
        if (sum < 0) {
            return -1;
        }
        return startIndex == gas.length ? 0 : startIndex;
    }
}