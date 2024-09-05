class Solution {
    public boolean canAttendMeetings(int[][] intervals) {
        if (intervals.length == 0) {
            return true;
        }
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
        int previousEnd = intervals[0][1];
        for (int i = 1; i < intervals.length; i++) {
            int currentStart = intervals[i][0];
            if (currentStart < previousEnd) {
                return false;
            }
            int currentEnd = intervals[i][1];
            previousEnd = currentEnd;
        }
        return true;
    }
}