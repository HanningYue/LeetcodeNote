/**
1. int[][], sort starts and ends in seperate arrays int[] starts and int[] ends
2. Traverse int[][], fill starts and ends
3. Sort both arrays,
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
        for (int current = 0; current < intervals.length; current++) {
            if (current == intervals.length - 1 || starts[current + 1] > ends[current]) {
                result.add(new int[]{starts[previous], ends[current]});
                previous = current + 1;
            }
        }
        return result.toArray(new int[result.size()][]);
    }
}