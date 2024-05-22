class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals, new Comparator<int[]>() {
            public int compare(int[] a, int[] b) {
                return Integer.compare(a[1], b[1]);
            }
        });

        int count = 1;
        int[] previousInterval = intervals[0];
        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] >= previousInterval[1]) {
                count++;
                previousInterval = intervals[i];
            }
        }
        return intervals.length - count;
    }
}