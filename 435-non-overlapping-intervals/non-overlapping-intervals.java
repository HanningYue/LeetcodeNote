class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        int notOverlapIntervals = notOverlap(intervals);
        return intervals.length - notOverlapIntervals;        
    }

    private int notOverlap(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> {
            return a[1] - b[1];
        });

        int count = 1;
        int end = intervals[0][1];
        for (int i = 0; i < intervals.length; i++) {
            int[] currentInterval = intervals[i];
            int start = currentInterval[0];
            if (start >= end) {
                count++;
                end = currentInterval[1];
            }
        }
        return count;
    }
}