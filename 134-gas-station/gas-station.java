class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int start = 0;
        int sum = 0, minSum = 0;
        
        for (int i = 0; i < gas.length; i++) {
            sum += gas[i] - cost[i];
            if (sum < minSum) {
                start = i + 1;
                minSum = sum;
            }
        }

        if (sum < 0) {
            return -1;
        }

        return start == gas.length ? -1 : start;
    }
}