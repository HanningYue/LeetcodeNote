class State {
    int vertex;
    int price;
    int stop;
    public State(int vertex, int price, int stop) {
        this.vertex = vertex;
        this.price = price;
        this.stop = stop;
    }
}
class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        Map<Integer, List<State>> graph = new HashMap<>();
        for (int i = 0; i < n; i++) {
            graph.putIfAbsent(i, new ArrayList<>());
        }
        for (int[] flight : flights) {
            int from = flight[0], to = flight[1], price = flight[2];
            graph.get(from).add(new State(to, price, 0));
        }
        PriorityQueue<State> heap = new PriorityQueue<>((a, b) -> a.price - b.price);
        heap.offer(new State(src, 0, 0));

        int[] minStopToCurrent = new int[n];
        Arrays.fill(minStopToCurrent, Integer.MAX_VALUE);
        minStopToCurrent[src] = 0;
        k = k + 1;
        while (!heap.isEmpty()) {
            State current = heap.poll();
            int currentVertex = current.vertex;
            int currentStop = current.stop;
            int currentPrice = current.price;
            
            if (currentStop > k || minStopToCurrent[currentVertex] < currentStop) {
                continue;
            }
            minStopToCurrent[currentVertex] = currentStop;

            if (currentVertex == dst) {
                return currentPrice;
            }
            
            for (State neighbor : graph.get(currentVertex)) {
                if (currentStop + 1 > k) {
                    continue;
                }
                heap.offer(new State(neighbor.vertex, currentPrice + neighbor.price, current.stop + 1));
            }
        }
        return -1;
    }
}