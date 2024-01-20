import java.util.*;

class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> result = new ArrayList<>();

        for (int i = 0; i < intervals.length; i++) {
            if (intervals[i][1] < newInterval[0]) {
                // Current interval ends before newInterval starts
                result.add(intervals[i]);
            } else if (intervals[i][0] > newInterval[1]) {
                // Current interval starts after newInterval ends
                result.add(newInterval);
                newInterval = intervals[i]; // Update newInterval to current interval
            } else {
                // Overlapping intervals, merge with newInterval
                newInterval[0] = Math.min(newInterval[0], intervals[i][0]);
                newInterval[1] = Math.max(newInterval[1], intervals[i][1]);
            }
        }

        // Add the last interval
        result.add(newInterval);

        return result.toArray(new int[result.size()][]);
    }
}
