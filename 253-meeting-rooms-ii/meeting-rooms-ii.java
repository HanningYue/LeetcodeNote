class Solution {
    public int minMeetingRooms(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
        PriorityQueue<int[]> heap = new PriorityQueue<>((a, b) -> a[1] - b[1]);
        
        int room = 1;
        for (int i = 0; i < intervals.length; i++) {
            int[] currentMeeting = intervals[i];
            while (!heap.isEmpty() && currentMeeting[0] >= heap.peek()[1]) {
                heap.poll();
            }
            heap.offer(currentMeeting);
            room = Math.max(room, heap.size());
        }
        return room;
    }
}