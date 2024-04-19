class Solution {
    public int minMeetingRooms(int[][] intervals) {
        if (intervals == null || intervals.length == 0) {
            return 0;
        }

        int room = 1;
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

        for (int i = 1; i < intervals.length; i++) {
            int[] currentMeeting = intervals[i];

            if (!heap.isEmpty() && currentMeeting[0] >= heap.peek()[1]) {
                heap.poll();
            }
            heap.offer(currentMeeting);
            room = Math.max(room, heap.size());
        }
        return room;
    }
}