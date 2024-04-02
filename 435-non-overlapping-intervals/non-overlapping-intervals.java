class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        int notOverlap = findNot(intervals);
        return intervals.length - notOverlap;        
    }
    private int findNot(int[][] intervals) {
        int count = 1;

        Arrays.sort(intervals, new Comparator<int[]>() {
            public int compare(int[] a, int[] b) {
                return a[1] - b[1];
            }
        });

        int end = intervals[0][1];
        for (int[] interval : intervals) {
            int start = interval[0];
            if (start >= end) {
                count++;
                end = interval[1];
            }
        }
        return count;
    }
}