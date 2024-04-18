class Solution {
    public int minCostConnectPoints(int[][] points) {
        PriorityQueue<int[]> heap = new PriorityQueue<int[]>(new Comparator<int[]>() {
            public int compare(int[] a, int[] b) {
                return a[1] - b[1];
            }
        });
        heap.offer(new int[]{0, 0});
        Set<Integer> visited = new HashSet<>();
        int cost = 0;

        while (visited.size() < points.length) {
            int[] point = heap.poll();
            int index = point[0];
            int distance = point[1];

            if (visited.contains(index)) {
                continue;
            }
            cost += distance;
            visited.add(index);
            
            for (int nextIndex = 0; nextIndex < points.length; nextIndex++) {
                int distanceToCurrent = Math.abs(points[nextIndex][0] - points[index][0])
                                       +Math.abs(points[nextIndex][1] - points[index][1]);
                heap.offer(new int[]{nextIndex, distanceToCurrent});
            }
        }
        return cost;
    }
}