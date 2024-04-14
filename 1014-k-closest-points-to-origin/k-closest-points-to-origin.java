class Solution {
    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<int[]> maxHeap = new PriorityQueue<>(new Comparator<int[]> () {
            public int compare(int[] a, int[] b) {
                int aManhattan = a[0] * a[0] + a[1] * a[1];
                int bManhattan = b[0] * b[0] + b[1] * b[1];
                return bManhattan - aManhattan;
            }
        });

        for (int[] point : points) {
            maxHeap.offer(point);
            if (maxHeap.size() > k) {
                maxHeap.poll();
            }
        }

        int[][] result = new int[k][2];
        int index = 0;
        while (!maxHeap.isEmpty()) {
            result[index++] = maxHeap.poll();
        }
        return result;
    }
}