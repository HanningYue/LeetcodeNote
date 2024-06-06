class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
        List<int[]> result = new ArrayList<>();

        int[] previousInterval = intervals[0];
        for (int i = 1; i < intervals.length; i++) {
            int[] currentInterval = intervals[i];
            if (currentInterval[0] > previousInterval[1]) {
                result.add(previousInterval);
                previousInterval = currentInterval;
            } else {
                previousInterval[1] = Math.max(previousInterval[1], currentInterval[1]);
            }
        }
        result.add(previousInterval);
        return result.toArray(new int[result.size()][]);
    }
}