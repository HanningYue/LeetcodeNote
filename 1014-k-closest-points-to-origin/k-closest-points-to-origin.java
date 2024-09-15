class Solution {
    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<int[]> heap = new PriorityQueue<>((new Comparator<int[]>() {
            public int compare(int[] a, int[] b) {
                return distance(a) - distance(b);
            }
        }));


        for (int[] point : points) {
            heap.offer(point);
        }

        int[][] result = new int[k][2];
        int i = 0;
        while (!heap.isEmpty() && i < k) {
            result[i++] = heap.poll();
        }
        return result;
    }
    private int distance(int[] point) {
        int x = point[0] * point[0];
        int y = point[1] * point[1];
        return x + y;
    }
}