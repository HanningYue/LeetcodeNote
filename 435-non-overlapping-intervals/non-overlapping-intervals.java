/**
1. Sort the intervals by their ending
2. Instead of counting how many need to be deducted, count how many intervals are independent
3. let the interval with smallest ending be the previous, 
4. Start traversing at 1, any later interval that has a greater start than the previous end, increase the independent count
5. update previous be the current
6. Return the DIFFERENCE of length - independent count
*/
class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> (a[1] - b[1]));

        int independentCount = 1;
        int[] previousStart = intervals[0];
        for (int current = 1; current < intervals.length; current++) {
            if (intervals[current][0] >= previousStart[1]) {
                independentCount++;
                previousStart = intervals[current];
            }
        }
        return intervals.length - independentCount;
    }
}