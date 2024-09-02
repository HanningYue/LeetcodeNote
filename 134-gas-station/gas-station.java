class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int totalGas = 0;
        for (int i = 0; i < gas.length; i++) {
            totalGas += gas[i] - cost[i];
        }
        if (totalGas < 0) {
            return -1;
        }

        int minSum = 0, result = 0, totalSum = 0;
        for (int i = 0; i < cost.length; i++) {
            totalSum += gas[i] - cost[i];
            if (totalSum < minSum) {
                minSum = totalSum;
                result = i + 1;
            }
        }
        return result == cost.length ? 0 : result;
    }
}