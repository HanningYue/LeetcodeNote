class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
        List<int[]> result = new ArrayList<>();
        int[] currentInterval = intervals[0];
        for (int i = 1; i < intervals.length; i++) {
            if (currentInterval[1] < intervals[i][0]) {
                result.add(currentInterval);
                currentInterval = intervals[i];
            } 
            else if (currentInterval[1] >= intervals[i][0] && currentInterval[0] <= intervals[i][1]) {
                currentInterval[0] = Math.min(currentInterval[0], intervals[i][0]);
                currentInterval[1] = Math.max(currentInterval[1], intervals[i][1]);
            }
        }
        result.add(currentInterval);
        return result.toArray(new int[result.size()][]);
    }
}