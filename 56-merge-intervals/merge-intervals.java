/**
Use a List<int[]> and return .toArray(new int[])
    iterate the intervals, compare the next interval start with the current interval ends
    if greater, add the [Last Visited starts(previous), current ends] to the List<int[]>
    Edge case: at the Last Index, add the last interval automatically since it is sorted
*/
class Solution {
    public int[][] merge(int[][] intervals) {
        if (intervals.length == 0 || intervals == null) {
            return new int[0][0];
        }
        int[] starts = new int[intervals.length];
        int[] ends = new int[intervals.length];
        
        for (int i = 0; i < intervals.length; i++) {
            starts[i] = intervals[i][0];
            ends[i] = intervals[i][1];
        }
        Arrays.sort(starts);
        Arrays.sort(ends);

        List<int[]> result = new ArrayList<>();
        int previous = 0;
        for (int i = 0; i < intervals.length; i++) {
            if (i == intervals.length - 1 || starts[i + 1] > ends[i]) {
                result.add(new int[]{starts[previous], ends[i]});
                previous = i + 1;
            }
        }
        return result.toArray(new int[result.size()][]);
    }
}