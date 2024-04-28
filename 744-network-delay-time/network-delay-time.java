class State {
    int vertex, cost;
    public State(int vertex, int cost) {
        this.vertex = vertex;
        this.cost = cost;
    }
}
class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        Map<Integer, Set<State>> graph = new HashMap<>();
        for (int i = 1; i <= n; i++) {
            graph.put(i, new HashSet<>());
        }
        for (int[] time : times) {
            int source = time[0], target = time[1], cost = time[2];
            graph.get(source).add(new State(target, cost));
        }

        int[] minTimeToCurrent = new int[n + 1];
        Arrays.fill(minTimeToCurrent, Integer.MAX_VALUE);
        minTimeToCurrent[k] = 0;

        PriorityQueue<State> heap = new PriorityQueue<>((a, b) -> a.cost - b.cost);
        heap.offer(new State(k, 0));

        while (!heap.isEmpty()) {
            State current = heap.poll();
            int currentVertex = current.vertex;
            int currentCost = current.cost;

            for (State neighbor : graph.get(currentVertex)) {
                int neighborVertex = neighbor.vertex;
                int costToNeighbor = neighbor.cost;
                int totalCost = currentCost + costToNeighbor;
                
                if (totalCost < minTimeToCurrent[neighborVertex]) {
                    minTimeToCurrent[neighborVertex] = totalCost;
                    heap.offer(new State(neighborVertex, totalCost));
                }
            }
        }

        int result = Integer.MIN_VALUE;
        for (int i = 1; i < minTimeToCurrent.length; i++) {
            if (minTimeToCurrent[i] == Integer.MAX_VALUE) {
                return -1;
            }
            result = Math.max(result, minTimeToCurrent[i]);
        }
        return result;
    }
}