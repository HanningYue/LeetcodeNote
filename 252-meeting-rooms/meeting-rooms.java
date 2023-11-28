/**
We need to check if there are any overlaps between intervals
    Sort the intervals by their start time, non-decreasing
    Iterate the intervals, check each interval with the next one
    If the current interval end is greater than the next interval start, return false
    otherwise, return true
*/
class Solution {
    public boolean canAttendMeetings(int[][] intervals) {
        int n = intervals.length;

        int[] starts = new int[n];
        int[] ends = new int[n];
        for (int i = 0; i < n; i++) {
            starts[i] = intervals[i][0];
            ends[i] = intervals[i][1];
        }
        Arrays.sort(starts);
        Arrays.sort(ends);

        for (int current = 0; current < n - 1; current++) {
            if (starts[current + 1] < ends[current]) {
                return false;
            }
        }
        return true;
    }
}