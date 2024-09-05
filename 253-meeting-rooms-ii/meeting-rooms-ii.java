class Solution {
    public int minMeetingRooms(int[][] intervals) {
        int n = intervals.length;
        int[] start = new int[n];
        int[] end = new int[n];
        for (int i = 0; i < n; i++) {
            start[i] = intervals[i][0];
            end[i] = intervals[i][1];
        }

        Arrays.sort(start);
        Arrays.sort(end);

        int startP = 0, endP = 0;
        int room = 0, maxRoom = 0;
        while (startP < n && endP < n) {
            if (start[startP] < end[endP]) {
                room++;
                startP++;
            } else if (start[startP] >= end[endP]) {
                room--;
                endP++;
            } 
            maxRoom = Math.max(maxRoom, room);
        }
        return maxRoom;
    }
}