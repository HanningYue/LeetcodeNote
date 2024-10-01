class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> result = new ArrayList<>();
        for (int i = 0; i < intervals.length; i++) {
            if (intervals[i][0] > newInterval[1]) {
                result.add(newInterval);
                newInterval = intervals[i];
            } else if (intervals[i][0] <= newInterval[1] && intervals[i][1] >= newInterval[0]) {
                newInterval[0] = Math.min(newInterval[0], intervals[i][0]);
                newInterval[1] = Math.max(newInterval[1], intervals[i][1]);
            } else {
                result.add(intervals[i]);
            }
        }
        result.add(newInterval);

        int[][] answer = new int[result.size()][];
        for (int i = 0; i < result.size(); i++) {
            answer[i] = result.get(i);
        }
        return answer;
    }
}