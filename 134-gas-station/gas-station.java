class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        
        int sum = 0, start = 0, minSum = 0;
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
        return start == gas.length ? 0 : start;
    }
}