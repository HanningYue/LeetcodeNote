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

        int[] resultArray = new int[n + 1];
        Arrays.fill(resultArray, Integer.MAX_VALUE);
        resultArray[k] = 0;

        PriorityQueue<State> heap = new PriorityQueue<>((a, b) -> a.cost - b.cost);
        heap.offer(new State(k, 0));
        while (!heap.isEmpty()) {
            State current = heap.poll();
            for (State neighbor : graph.get(current.vertex)) {
                if (neighbor.cost + current.cost < resultArray[neighbor.vertex]) {
                    resultArray[neighbor.vertex] = neighbor.cost + current.cost;
                    heap.offer(new State(neighbor.vertex, neighbor.cost + current.cost));
                }
            }
        }

        int result = Integer.MIN_VALUE;
        for (int i = 1; i <= n; i++) {
            if (resultArray[i] == Integer.MAX_VALUE) {
                return -1;
            }
            result = Math.max(result, resultArray[i]);
        }
        return result;
    }
}
