/**
Iterate two arrays, calculate the total cost and total gas, compare
    If cost is greater than gas, return -1
We want to find the first gas start as start, so if the net gas of (cost - gas) is less than 0,
the current gas station can not be the starting station. So update result = current + 1
Iterate the array, since the answer is unique, add total gas to a variable and reset variable to 0 if less than 0
*/
class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int totalGas = 0, totalCost = 0;
        for (int i = 0; i < gas.length; i++) {
            totalGas += gas[i];
            totalCost += cost[i];
        }
        if (totalCost > totalGas) {
            return -1;
        }

        //Guaranteed to have a result
        int total = 0, result = 0;
        for (int i = 0; i < gas.length; i++) {
            total += gas[i] - cost[i];
            if (total < 0) {
                total = 0;
                result = i + 1;
            }
        }
        return result;
    }
}