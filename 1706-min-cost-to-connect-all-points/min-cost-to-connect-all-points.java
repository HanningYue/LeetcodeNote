class Solution {
    public int minCostConnectPoints(int[][] points) {
        Set<Integer> visitedNode = new HashSet<>();
        PriorityQueue<int[]> minHeap = new PriorityQueue<>((a, b) -> (a[0] - b[0]));
        minHeap.offer(new int[]{0, 0});
        int cost = 0;

        while (visitedNode.size() < points.length) {
            int[] point = minHeap.poll();
            int currentWeight = point[0];
            int currentNode = point[1];
            if (visitedNode.contains(currentNode)) {
                continue;
            }

            visitedNode.add(currentNode);
            cost += currentWeight;

            for (int nextNode = 0; nextNode < points.length; nextNode++) {
                if (visitedNode.contains(nextNode)) {
                    continue;
                }

                int nextWeight = Math.abs(points[nextNode][0] - points[currentNode][0])
                                +Math.abs(points[nextNode][1] - points[currentNode][1]);
                minHeap.offer(new int[]{nextWeight, nextNode});
            }
        }
        return cost;
    }
}