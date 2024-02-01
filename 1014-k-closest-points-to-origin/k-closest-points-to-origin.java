class Solution {
    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<int[]> maxHeap = new PriorityQueue<int[]>(new Comparator<int[]>() {
            public int compare(int[] a, int[] b) {
                return Double.compare(calculateDistance(b), calculateDistance(a));
            }
        });
        for (int i = 0; i < k; i++) {
            maxHeap.offer(points[i]);
        }
        for (int i = k; i < points.length; i++) {
            int[] last = maxHeap.peek();
            if (!maxHeap.isEmpty() && calculateDistance(last) > calculateDistance(points[i])) {
                maxHeap.poll();
                maxHeap.offer(points[i]);
            }
        }
        int[][] result = new int[k][2];
        for (int i = 0; i < k && !maxHeap.isEmpty(); i++) {
            result[i] = maxHeap.poll();
        }
        return result;
    }
    private double calculateDistance(int[] point) {
        return Math.sqrt(point[0] * point[0] + point[1] * point[1]);
    }
}