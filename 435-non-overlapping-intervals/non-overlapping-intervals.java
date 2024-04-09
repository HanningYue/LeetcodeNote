class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        int notOverlapCount = notOverlap(intervals);     
        return intervals.length - notOverlapCount;   
    }
    public int notOverlap(int[][] intervals) {
        Arrays.sort(intervals, new Comparator<int[]>() {
            public int compare(int[] a, int[] b) {
                return a[1] - b[1];
            }
        });

        int count = 1;
        int prevEnd = intervals[0][1];
        for (int i = 1; i < intervals.length; i++) {
            int currentStart = intervals[i][0];
            int currentEnd = intervals[i][1];

            if (currentStart >= prevEnd) {
                count++;
                prevEnd = currentEnd;
            }
        }
        return count;
    }
}