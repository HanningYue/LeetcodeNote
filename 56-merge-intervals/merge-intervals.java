class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));

        List<int[]> result = new ArrayList<>();
        int[] previousInterval = intervals[0];

        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] > previousInterval[1]) {
                result.add(previousInterval);
                previousInterval = intervals[i];
            } else {
                previousInterval[0] = Math.min(previousInterval[0], intervals[i][1]);
                previousInterval[1] = Math.max(previousInterval[1], intervals[i][1]);
            }
        }
        result.add(previousInterval);

        return result.toArray(new int[result.size()][]);
    }
}
