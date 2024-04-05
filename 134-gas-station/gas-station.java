class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int total = 0;
        
        int start = 0, min = 0;
        for (int i = 0; i < gas.length; i++) {
            total += gas[i] - cost[i];
            if (total < min) {
                min = total;
                start = i + 1;
            }
        }

        if (total < 0) {
            return -1;
        }
        return start == gas.length ? -1 : start;
    }
}