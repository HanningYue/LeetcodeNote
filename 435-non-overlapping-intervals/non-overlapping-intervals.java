class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        return intervals.length - nonOverLap(intervals);
    }
    private int nonOverLap(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> a[1] - b[1]);
        int count = 1;
        int[] previousInterval = intervals[0];
        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] >= previousInterval[1]) {
                count++;
                previousInterval = intervals[i];
            }
        }
        return count;
    }
}
