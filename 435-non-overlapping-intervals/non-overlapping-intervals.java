class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
        int result = 0;
        int[] previous = intervals[0];
        for (int i = 1; i < intervals.length; i++) {
            int[] current = intervals[i];
            if (previous[1] > current[0]) {
                result++;
                previous[1] = Math.min(previous[1], current[1]);
            } else {
                previous = current;
            }
        }
        return result;
    }
}