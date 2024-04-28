class Solution {
    public int minMeetingRooms(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
        PriorityQueue<int[]> heap = new PriorityQueue<>((a, b) -> a[1] - b[1]);
        int maxRoom = 1;

        for (int i = 0; i < intervals.length; i++) {
            while (!heap.isEmpty() && intervals[i][0] >= heap.peek()[1]) {
                heap.poll();
            }
            heap.offer(intervals[i]);
            maxRoom = Math.max(maxRoom, heap.size());
        }
        return maxRoom;
    }
}