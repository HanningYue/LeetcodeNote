class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> result = new ArrayList<>();
        
        for (int i = 0; i < intervals.length; i++) {
            int[] currentInterval = intervals[i];
            if (currentInterval[0] > newInterval[1]) {
                result.add(newInterval);
                newInterval = currentInterval;
            } else if (newInterval[0] > currentInterval[1]) {
                result.add(currentInterval);
            } else if (newInterval[0] <= currentInterval[1] && newInterval[1] >= currentInterval[0]) {
                newInterval[0] = Math.min(newInterval[0], currentInterval[0]);
                newInterval[1] = Math.max(newInterval[1], currentInterval[1]);
            }
        }
        result.add(newInterval);
        return result.toArray(new int[result.size()][]);
    }
}