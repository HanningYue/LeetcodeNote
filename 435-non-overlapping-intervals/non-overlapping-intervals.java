/**
1. Sort the intervals by their ending, ascending order
2. Instead of counting how many need to be deducted, count how many intervals are independent
3. let the interval with smallest ending be the previous, 
4. Start traversing at 1, any later interval that has a greater(or equal) start than the previous end, 
    increase the independent count
5. update previous be the current
6. Return the DIFFERENCE of length - independent count
*/
class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> (a[1] - b[1]));
        
        int previousEnd = 0, independent = 1;
        for (int current = 0; current < intervals.length; current++) {
            if (intervals[current][0] >= intervals[previousEnd][1]) {
                independent++;
                previousEnd = current;
            }
        }
        return intervals.length - independent;
    }
}