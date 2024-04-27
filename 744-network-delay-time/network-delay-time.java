class State {
    int node, time;
    public State(int node, int time) {
        this.node = node;
        this.time = time;
    }
}
class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        Map<Integer, List<State>> graph = new HashMap<>();
        for (int i = 1; i <= n; i++) {
            graph.put(i, new ArrayList<>());
        }
        for (int[] time : times) {
            int source = time[0], target = time[1], cost = time[2];
            graph.get(source).add(new State(target, cost));
        }

        // Dijkstra's algorithm to find the shortest path to all nodes
        PriorityQueue<State> heap = new PriorityQueue<>((a, b) -> a.time - b.time);
        heap.offer(new State(k, 0)); // start from the source node k

        Map<Integer, Integer> minTimeToNode = new HashMap<>();
        while (!heap.isEmpty()) {
            State current = heap.poll();

            if (minTimeToNode.containsKey(current.node)) {
                continue;
            }

            // Record the shortest time to reach this node
            minTimeToNode.put(current.node, current.time);

            // Explore all neighbors
            for (State neighbor : graph.get(current.node)) {
                if (!minTimeToNode.containsKey(neighbor.node)) {
                    heap.offer(new State(neighbor.node, current.time + neighbor.time));
                }
            }
        }

        // If we reached all nodes, return the maximum time
        if (minTimeToNode.size() != n) return -1; // not all nodes are reachable
        int maxTime = 0;
        for (int time : minTimeToNode.values()) {
            maxTime = Math.max(maxTime, time);
        }
        return maxTime;
    }
}
