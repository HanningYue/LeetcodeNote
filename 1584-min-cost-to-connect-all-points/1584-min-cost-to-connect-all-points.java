/*
想要找到最短的cost链接所有的point in a 2D ARRAY
We can start at any point, for each point, BFS all the rest points, take the minimum edge, go to the minimum edge point, repeat the process. Until reach end of the  int[][] points
PriorityQueue<> //{weight, node}, initialize with {0, 0}
Set<> //Check duplicate
MST(minimum spanning tree) - Prim's Algorithm
We need to create out own edges, since each point can go to every other point
Apply Prim's Algo  O(n^2logn)
1. BFS, use a minHeap, compare the 0-index(weight) of int[]
2. for each int[], {weight from start to current node, current node}
3. HashSet to check duplicate, check whether the currentNode is visited or not
4. For loop, calculate the distance between current node to all the rest nodes
*/
// new int[] {minimum weight at each point, the point index in points array}
class Solution {
    public int minCostConnectPoints(int[][] points) {
        PriorityQueue<int[]> minHeap = new PriorityQueue<>((a, b) -> (a[0] - b[0]));
        minHeap.offer(new int[] {0, 0});
        int cost = 0;
        Set<Integer> visited = new HashSet<>();
        
        while (visited.size() < points.length) {
            int[] point = minHeap.poll();
            int currentWeight = point[0];
            int currentNode = point[1];
            
            if (visited.contains(currentNode)) continue;
            visited.add(currentNode);
            cost += currentWeight;
            
            for (int nextNode = 0; nextNode < points.length; nextNode++) {
                if (!visited.contains(nextNode)) {
                    int nextWeight = Math.abs(points[nextNode][0] - points[currentNode][0])
                                    +Math.abs(points[nextNode][1] - points[currentNode][1]);
                    minHeap.offer(new int[] {nextWeight, nextNode});
                }
            }
        }
        return cost;
    }
}