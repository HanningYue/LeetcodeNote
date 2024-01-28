class Solution {
    public int[] findRightInterval(int[][] intervals) {
        //{start, index} {end, index}
        PriorityQueue<int[]> minStart = new PriorityQueue<>(new Comparator<int[]>(){
            public int compare(int[] a, int[] b) {
                return a[0] - b[0];
            }
        });
        PriorityQueue<int[]> minEnd = new PriorityQueue<>(new Comparator<int[]>(){
            public int compare(int[] a, int[] b) {
                return a[0] - b[0];
            }
        });
        for (int i = 0; i < intervals.length; i++) {
            minStart.offer(new int[]{intervals[i][0], i});
            minEnd.offer(new int[]{intervals[i][1], i});
        }

        int[] result = new int[intervals.length];
        for (int i = 0; i < intervals.length; i++) {
            result[i] = -1;
        }
        while (!minEnd.isEmpty()) {
            int[] currentMinEnd = minEnd.poll();
            int currentVal = currentMinEnd[0];
            int currentIdx = currentMinEnd[1];
            while (!minStart.isEmpty() && minStart.peek()[0] < currentVal) {
                minStart.poll();
            }
            if (minStart.isEmpty()) {
                return result;
            }
            result[currentIdx] = minStart.peek()[1];
        }
        return result;
    }
}