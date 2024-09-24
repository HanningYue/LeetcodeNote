class State {
    int index = 0;
    int distance = 0;
    public State(int index, int distance) {
        this.index = index;
        this.distance = distance;
    }
}
class Solution {
    public int minCostConnectPoints(int[][] points) {
        PriorityQueue<State> heap = new PriorityQueue<>((a, b) -> a.distance - b.distance);
        heap.offer(new State(0, 0));
 
        int cost = 0;
        Set<Integer> visitedPoints = new HashSet<>();
        while (visitedPoints.size() < points.length) {
            State current = heap.poll();
            if (visitedPoints.contains(current.index)) {
                continue;
            }

            visitedPoints.add(current.index);
            cost += current.distance;
            for (int nextIndex = 0; nextIndex < points.length; nextIndex++) {
                int newDistance = Math.abs(points[nextIndex][0] - points[current.index][0])
                                + Math.abs(points[nextIndex][1] - points[current.index][1]);
                heap.offer(new State(nextIndex, newDistance));
            }
        }
        return cost;
    }
}