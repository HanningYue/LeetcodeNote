/**
1. int[][], sort starts and ends in seperate arrays int[] starts and int[] ends
2. Traverse int[][], fill starts and ends
3. Sort both arrays,
*/
class Solution {
    public int[][] merge(int[][] intervals) {
        int n = intervals.length;

        int[] starts = new int[n];
        int[] ends = new int[n];
        for (int i = 0; i < n; i++) {
            starts[i] = intervals[i][0];
            ends[i] = intervals[i][1];
        }
        Arrays.sort(starts);
        Arrays.sort(ends);

        int previousStart = 0;
        List<int[]> result = new ArrayList<>();
        for (int current = 0; current < intervals.length; current++) {
            if (current == intervals.length - 1 || starts[current + 1] > ends[current]) {
                result.add(new int[]{starts[previousStart], ends[current]});
                previousStart = current + 1;
            }
        }
        return result.toArray(new int[result.size()][]);
    }
}