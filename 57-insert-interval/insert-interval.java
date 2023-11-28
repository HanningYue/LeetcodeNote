/**
Refer to 56, same merge process
EXTRA step, add the new interval at the end of starts and ends array
*/
class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        int n = intervals.length + 1;
        int[] start = new int[n];
        int[] end = new int[n];

        for (int i = 0; i < intervals.length; i++) {
            start[i] = intervals[i][0];
            end[i] = intervals[i][1];
        }
        start[intervals.length] = newInterval[0];
        end[intervals.length] = newInterval[1];
        Arrays.sort(start);
        Arrays.sort(end);

        int previousStart = 0;
        List<int[]> result = new ArrayList<>();
        for (int current = 0; current < n; current++) {
            if (current == n - 1 || start[current + 1] > end[current]) {
                result.add(new int[]{start[previousStart], end[current]});
                previousStart = current + 1;
            }
        }
        return result.toArray(new int[result.size()][]);
    }
}