class Solution {
    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<int[]> heap = new PriorityQueue<>((new Comparator<int[]>() {
            public int compare(int[] a, int[] b) {
                int distanceA = distance(a);
                int distanceB = distance(b);
                return distanceB - distanceA;
            }
        }));


        for (int[] point : points) {
            heap.offer(point);
            if (heap.size() > k) {
                heap.poll();
            }
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