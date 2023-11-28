/**
Create two int[], one for SORTED meeting start, one for SORTED meeting end
If the second meeting starts before the first meeting ends, increase the room count
    In code, this is start[current] < end[previousStart]
    Increase the previous by 1, since it is sorted, we need to check the MAX ending time
*/
class Solution {
    public int minMeetingRooms(int[][] intervals) {
        int n = intervals.length;

        int[] starts = new int[n];
        int[] ends = new int[n];
        for (int i = 0; i < intervals.length; i++) {
            starts[i] = intervals[i][0];
            ends[i] = intervals[i][1];
        }
        Arrays.sort(starts);
        Arrays.sort(ends);
        
        int previousStart = 0, rooms = 0;
        for (int current = 0; current < n; current++) {
            if (starts[current] < ends[previousStart]) {
                rooms++;
            } else {
                previousStart++;
            }
        }
        return rooms;
    }
}