/*
MST(minimum spanning tree) - Prim's Algorithm
想要找到最短的cost链接所有的point
1. We need to create out own edges, since each point can go to every other point
2. Apply Prim's Algo  O(n^2logn) BFS
*/
class Solution {
    public int minCostConnectPoints(int[][] points) {
        Set<Integer> visited = new HashSet<>();
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> (a[0] - b[0])); //{weight, node};
        pq.offer(new int[] {0, 0});

        int len = points.length;
        int cost = 0;

        while (visited.size() < len) {
            int[] point = pq.poll();
            int weight = point[0];
            int currentNode = point[1];

            if (visited.contains(currentNode)) continue;
            visited.add(currentNode);
            cost += weight;

            for (int nextNode = 0; nextNode < len; nextNode++) {
                if (!visited.contains(nextNode)) {
                    int nextWeight = Math.abs(points[nextNode][0] - points[currentNode][0]) + 
                                     Math.abs(points[nextNode][1] - points[currentNode][1]);
                    pq.offer(new int[] {nextWeight, nextNode});
                }
            }
        }
        return cost;
    }
}