class Solution {
    public int minMeetingRooms(int[][] intervals) {
        Arrays.sort(intervals, new Comparator<int[]>() {
            public int compare(int[] a, int[] b) {
                return a[0] - b[0];
            }
        });
        PriorityQueue<int[]> heap = new PriorityQueue<>(new Comparator<int[]>() {
            public int compare(int[] a, int[] b) {
                return a[1] - b[1];
            }
        });
        heap.offer(intervals[0]);
        int room = 1;

        for (int i = 1; i < intervals.length; i++) {
            int[] currentInterval = intervals[i];
            if (!heap.isEmpty() && currentInterval[0] >= heap.peek()[1]) {
                heap.poll();
            }
            heap.offer(currentInterval);
            room = Math.max(room, heap.size());
        }
        return room;
    }
}