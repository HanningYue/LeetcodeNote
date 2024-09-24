class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
        List<int[]> result = new ArrayList<>();
        
        int[] previous = intervals[0];
        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] <= previous[1]) {
                previous[0] = Math.min(previous[0], intervals[i][0]);
                previous[1] = Math.max(previous[1], intervals[i][1]);
            } else if (intervals[i][0] > previous[1]) {
                result.add(previous);
                previous = intervals[i];
            }
        }
        result.add(previous);
        
        return result.toArray(new int[result.size()][]);
    }
}