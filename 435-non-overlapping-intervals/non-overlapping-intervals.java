class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
        int result = 0;
        int[] current = intervals[0];
        for (int i = 1; i < intervals.length; i++) {
            if (current[1] <= intervals[i][0]) {
                current = intervals[i];
            } else if (current[1] >= intervals[i][0] && current[0] <= intervals[i][1]){
                result++;
                current[1] = Math.min(current[1], intervals[i][1]);
            }
        }
        return result;
    }
}