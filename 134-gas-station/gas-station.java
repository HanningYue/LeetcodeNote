class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int totalCost = 0;
        for (int i = 0; i < gas.length; i++) {
            totalCost += gas[i] - cost[i];
        }
        if (totalCost < 0) {
            return -1;
        }

        int minSum = 0, localSum = 0, result = 0;
        for (int i = 0; i < gas.length; i++) {
            localSum += gas[i] - cost[i];
            if (localSum < minSum) {
                minSum = localSum;
                result = i + 1;
            }
        }
        return result == gas.length ? 0 : result;
    }
}