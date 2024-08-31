class State {
    int vertex, cost;
    public State(int vertex, int cost) {
        this.vertex = vertex;
        this.cost = cost;
    }
}

class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        Map<Integer, List<State>> graph = new HashMap<>();
        for (int i = 1; i <= n; i++) {
            graph.put(i, new ArrayList<>());
        }
        for (int[] time : times) {
            int from = time[0], to = time[1], cost = time[2];
            graph.get(from).add(new State(to, cost));
        }

        int[] minCostToEach = new int[n + 1];
        Arrays.fill(minCostToEach, Integer.MAX_VALUE);
        minCostToEach[k] = 0;
        
        PriorityQueue<State> heap = new PriorityQueue<>(new Comparator<State>() {
            public int compare(State a, State b) {
                return a.cost - b.cost;
            }
        });
        heap.offer(new State(k, 0));
        
        while (!heap.isEmpty()) {
            State current = heap.poll();
            for (State neighbor : graph.get(current.vertex)) {
                if (current.cost + neighbor.cost < minCostToEach[neighbor.vertex]) {
                    minCostToEach[neighbor.vertex] = current.cost + neighbor.cost;
                    heap.offer(new State(neighbor.vertex, current.cost + neighbor.cost));
                }
            }
        }

        int result = 0;
        for (int i = 1; i <= n; i++) {
            if (minCostToEach[i] == Integer.MAX_VALUE) {
                return -1;
            }
            result = Math.max(result, minCostToEach[i]);
        }       
        return result;
    }
}