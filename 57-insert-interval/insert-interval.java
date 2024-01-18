class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> result = new ArrayList<>();
        int start = newInterval[0];
        int end = newInterval[1];
        int i = 0;
        while (i < intervals.length && intervals[i][1] < start) {
            result.add(intervals[i]);
            i++;
        }
        while (i < intervals.length && end >= intervals[i][0]) {
            start = Math.min(start, intervals[i][0]);
            end = Math.max(end, intervals[i][1]);
            i++;
        }
        result.add(new int[]{start, end});
        while (i < intervals.length) {
            result.add(intervals[i]);
            i++;
        }
        return result.toArray(new int[result.size()][]);
    }
}