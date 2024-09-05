class Solution {
    public boolean canAttendMeetings(int[][] intervals) {
        if (intervals.length == 0) {
            return true;
        }
        
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
        int previousEnd = intervals[0][1];
        for (int i = 1; i < intervals.length; i++) {
            int[] currentMeeting = intervals[i];
            if (currentMeeting[0] < previousEnd) {
                return false;
            } else if (currentMeeting[0] >= previousEnd) {
                previousEnd = currentMeeting[1];
            }
        }
        return true;
    }
}