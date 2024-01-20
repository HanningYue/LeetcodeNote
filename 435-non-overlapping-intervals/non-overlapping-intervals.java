class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
        int result = 0;
        int[] previous = intervals[0];
        for (int i = 1; i < intervals.length; i++) {
            if (previous[1] > intervals[i][0]) {
                previous[1] = Math.min(previous[1], intervals[i][1]);
                result++;
            } else {
                previous = intervals[i];
            }
        }
        return result;
    }
}