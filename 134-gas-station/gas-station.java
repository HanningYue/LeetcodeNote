class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int start = 0;
        int sum = 0;
        int minSum = 0;
        for (int i = 0; i < gas.length; i++) {
            sum += gas[i] - cost[i];
            if (sum < minSum) {
                minSum = sum;
                start = i + 1;
            }
        }
        if (sum < 0) {
            return -1;
        }
        if (start == gas.length) {
            return 0;
        }
        return start;
    }
}