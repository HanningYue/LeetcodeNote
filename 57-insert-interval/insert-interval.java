/**
Refer to 56, same merge process
EXTRA step, add the new interval at the end of starts and ends array
*/
class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        int n = intervals.length + 1;

        int[] starts = new int[n];
        int[] ends = new int[n];
        for (int i = 0; i < intervals.length; i++) {
            starts[i] = intervals[i][0];
            ends[i] = intervals[i][1];
        }
        starts[intervals.length] = newInterval[0];
        ends[intervals.length] = newInterval[1];
        Arrays.sort(starts);
        Arrays.sort(ends);
        
        int previousStart = 0;
        List<int[]> result = new ArrayList<>();
        for (int current = 0; current < n; current++) {
            if (current == n - 1 || starts[current + 1] > ends[current]) {
                result.add(new int[]{starts[previousStart], ends[current]});
                previousStart = current + 1;
            }
        }
        return result.toArray(new int[result.size()][]);
    }
}