class Solution {
    public int[][] merge(int[][] intervals) {
        List<int[]> result = new ArrayList<>();
        int n = intervals.length;
        
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
        int[] previousInterval = intervals[0];
        for (int i = 1; i < intervals.length; i++) {
            int[] currentInterval = intervals[i];
            if (currentInterval[0] <= previousInterval[1]) {
                previousInterval[0] = Math.min(previousInterval[0], currentInterval[0]);
                previousInterval[1] = Math.max(previousInterval[1], currentInterval[1]);
            } else if (currentInterval[0] > previousInterval[1]) {
                result.add(previousInterval);
                previousInterval = currentInterval;
            }
        }

        result.add(previousInterval);
        int[][] answer = new int[result.size()][];
        for (int i = 0; i < result.size(); i++) {
            answer[i] = result.get(i);
        }
        return answer;
    }
}