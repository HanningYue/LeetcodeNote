class Solution {
    public int[] findRightInterval(int[][] intervals) {
        PriorityQueue<int[]> minEnd = new PriorityQueue<>(new Comparator<int[]>(){
            public int compare(int[] a, int[] b) {
                return a[0] - b[0];
            }
        });
        PriorityQueue<int[]> minStart = new PriorityQueue<>(new Comparator<int[]>(){
            public int compare(int[] a, int[] b) {
                return a[0] - b[0];
            }
        });
        for (int i = 0; i < intervals.length; i++) {
            minEnd.offer(new int[]{intervals[i][1], i});
            minStart.offer(new int[]{intervals[i][0], i});
        }

        int[] result = new int[intervals.length];
        for (int i = 0; i < intervals.length; i++) {
            result[i] = -1;
        }

        while (!minEnd.isEmpty()) {
            int[] currentMinEndInterval = minEnd.poll();
            int currentMinEnd = currentMinEndInterval[0];
            int currentMinEndIdx = currentMinEndInterval[1];

            while (!minStart.isEmpty() && minStart.peek()[0] < currentMinEnd) {
                minStart.poll();
            }
            if (minStart.isEmpty()) {
                return result;
            }
            result[currentMinEndIdx] = minStart.peek()[1];
        }
        return result;
    }
}