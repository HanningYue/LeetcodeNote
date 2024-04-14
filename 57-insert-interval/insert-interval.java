class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> result = new ArrayList<>();
        Arrays.sort(intervals, new Comparator<int[]>() {
            public int compare(int[] a, int[] b) {
                return a[0] - b[0];
            }
        });
        for (int i = 0; i < intervals.length; i++) {
            int[] currentInterval = intervals[i];
            if (newInterval[0] > currentInterval[1]) {
                result.add(currentInterval);
            } else if (currentInterval[0] > newInterval[1]) {
                result.add(newInterval);
                newInterval = currentInterval;
            } else {
                newInterval[0] = Math.min(newInterval[0], currentInterval[0]);
                newInterval[1] = Math.max(newInterval[1], currentInterval[1]);
            }
        }
        result.add(newInterval);
        return result.toArray(new int[result.size()][]);
    }
}