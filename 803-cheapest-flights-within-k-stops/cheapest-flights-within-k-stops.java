class State {
    int price, stop, vertex;
    public State(int price, int stop, int vertex) {
        this.price = price;
        this.stop = stop;
        this.vertex = vertex;
    }
}
class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        k = k + 1;
        Map<Integer, List<State>> graph = new HashMap<>();
        for (int i = 0; i < n; i++) {
            graph.put(i, new ArrayList<>());
        }
        for (int[] flight : flights) {
            int from = flight[0], to = flight[1], price = flight[2];
            graph.get(from).add(new State(price, 0, to));
        }

        PriorityQueue<State> heap = new PriorityQueue<>((a, b) -> a.price - b.price);

        int[] minimumStopToCurrent = new int[n];
        Arrays.fill(minimumStopToCurrent, Integer.MAX_VALUE);
        minimumStopToCurrent[src] = 0;

        heap.offer(new State(0, 0, src));
        while (!heap.isEmpty()) {
            State current = heap.poll();
            if (current.stop > minimumStopToCurrent[current.vertex] || current.stop > k) {
                continue;
            }

            minimumStopToCurrent[current.vertex] = current.stop;
            if (current.vertex == dst) {
                return current.price;
            }

            for (State neighbor : graph.get(current.vertex)) {
                heap.offer(
                    new State(current.price + neighbor.price, current.stop + 1, neighbor.vertex)
                );
            }
        }
        return -1;
    }
}