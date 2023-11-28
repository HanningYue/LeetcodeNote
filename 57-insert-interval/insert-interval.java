/**
Refer to 56, same merge process, need to add up the newInterval in the edge case and adjust index in merging
*/
class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        if (intervals.length == 0 || intervals == null) {
            return new int[][] {newInterval};
        }

        int[] starts = new int[intervals.length + 1];
        int[] ends = new int[intervals.length + 1];
        for (int i = 0; i < intervals.length; i++) {
            starts[i] = intervals[i][0];
            ends[i] = intervals[i][1];
        }
        starts[intervals.length] = newInterval[0];
        ends[intervals.length] = newInterval[1];
        Arrays.sort(starts);
        Arrays.sort(ends);

        List<int[]> result = new ArrayList<>();
        int previous = 0;
        for (int current = 0; current < intervals.length + 1; current++) {
            if (current == intervals.length || starts[current + 1] > ends[current]) {
                result.add(new int[]{starts[previous], ends[current]});
                previous = current + 1;
            }
        }
        return result.toArray(new int[result.size()][]);
    }
}