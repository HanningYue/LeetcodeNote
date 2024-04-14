class Solution {
    public int[][] merge(int[][] intervals) {
        List<int[]> result = new ArrayList<>();
        Arrays.sort(intervals, new Comparator<int[]> () {
            public int compare(int[] a, int[] b) {
                return a[0] - b[0];
            }
        });

        int[] previousInterval = intervals[0];
        for (int i = 1; i < intervals.length; i++) {
            int[] currentInterval = intervals[i];
            if (currentInterval[0] > previousInterval[1]) {
                result.add(previousInterval);
                previousInterval = currentInterval;
            } else if (previousInterval[0] > currentInterval[1]) {
                result.add(currentInterval);
            } else {
                previousInterval[1] = Math.max(previousInterval[1], currentInterval[1]);
                previousInterval[0] = Math.min(previousInterval[0], currentInterval[0]);
            }
        }
        result.add(previousInterval);
        return result.toArray(new int[result.size()][]);
    }
}