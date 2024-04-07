class Solution {
    public int[][] merge(int[][] intervals) {
        List<int[]> result = new ArrayList<>();
        Arrays.sort(intervals, (a, b) -> {
            return a[0] - b[0];
        });

        result.add(intervals[0]);
        for (int i = 1; i < intervals.length; i++) {
            int[] currentInterval = intervals[i];
            int[] lastInterval = result.get(result.size() - 1);
            if (currentInterval[0] <= lastInterval[1]) {
                lastInterval[1] = Math.max(lastInterval[1], currentInterval[1]);
            } else {
                result.add(currentInterval);
            }
        }
        
        return result.toArray(new int[0][0]);
    }
}