class Solution {
    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<int[]> heap = new PriorityQueue<>(new Comparator<int[]>() {
            public int compare(int[] a, int[] b) {
                int distanceA = a[0] * a[0] + a[1] * a[1];
                int distanceB = b[0] * b[0] + b[1] * b[1];
                return distanceB - distanceA;
            }
        });
        for (int[] point : points) {
            heap.offer(point);
            if (heap.size() > k) {
                heap.poll();
            }
        }
        
        int[][] result = new int[k][2];
        int index = 0;
        while (!heap.isEmpty()) {
            result[index++] = heap.poll();
        }
        return result;
    }
}