class Solution {
    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<int[]> heap = new PriorityQueue<>(new Comparator<int[]>() {
            public int compare(int[] a, int[] b) {
                int aManhattan = a[0] * a[0] + a[1] * a[1];
                int bManhattan = b[0] * b[0] + b[1] * b[1];
                return aManhattan - bManhattan;
            }
        });
        for (int[] point : points) {
            heap.offer(point);
        }

        int[][] result = new int[k][2];
        int index = 0;
        while (!heap.isEmpty() && index < k) {
            result[index++] = heap.poll();
        }
        return result;
    }
}