class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> a[1] - b[1]);
        int distinct = 1;
        int[] previous = intervals[0];
        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] >= previous[1]) {
                previous = intervals[i];
                distinct++;
            }
        }
        return intervals.length - distinct;
    }
}