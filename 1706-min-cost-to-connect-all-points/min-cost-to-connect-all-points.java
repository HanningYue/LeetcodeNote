class Solution {
    public int minCostConnectPoints(int[][] points) {
        PriorityQueue<Pair> heap = new PriorityQueue<>((a, b) -> a.distance - b.distance);
        heap.offer(new Pair(0, 0));
        Set<Integer> visited = new HashSet<>();
        int cost = 0;
        
        while (visited.size() < points.length) {
            Pair currentPoint = heap.poll();
            if (visited.contains(currentPoint.index)) {
                continue;
            } 

            visited.add(currentPoint.index);
            cost += currentPoint.distance;
            for (int nextPoint = 0; nextPoint < points.length; nextPoint++) {
                int nextDistance = Math.abs(points[nextPoint][0] - points[currentPoint.index][0]) + Math.abs(points[nextPoint][1] - points[currentPoint.index][1]);
                heap.offer(new Pair(nextPoint, nextDistance));
            }
        }
        return cost;
    }
}
class Pair {
    int index, distance;
    public Pair(int index, int distance) {
        this.index = index;
        this.distance = distance;
    }
}