class State {
    int vertex, cost, stop;
    public State(int vertex, int cost, int stop) {
        this.vertex = vertex;
        this.cost = cost;
        this.stop = stop;
    }
}
class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        Map<Integer, List<State>> graph = new HashMap<>();
        for (int i = 0; i < n; i++) {
            graph.put(i, new ArrayList<>());
        }
        for (int[] flight : flights) {
            int from = flight[0], to = flight[1], cost = flight[2];
            graph.get(from).add(new State(to, cost, 0));
        }

        int[] minStopToCurrent = new int[n];
        Arrays.fill(minStopToCurrent, Integer.MAX_VALUE);
        
        k = k + 1;
        PriorityQueue<State> heap = new PriorityQueue<>((a, b) -> a.cost - b.cost);
        heap.offer(new State(src, 0, 0));
        while (!heap.isEmpty()) {
            State current = heap.poll();
            if (current.stop > minStopToCurrent[current.vertex] || current.stop > k) {
                continue;
            }

            minStopToCurrent[current.vertex] = current.stop;
            if (current.vertex == dst) {
                return current.cost;
            }

            for (State neighbor : graph.get(current.vertex)) {
                heap.offer(new State(neighbor.vertex, neighbor.cost + current.cost, current.stop + 1));
            }
        }
        return -1;
    }
}