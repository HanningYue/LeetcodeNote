class State {
    int city, cost, stop;
    public State(int city, int cost, int stop) {
        this.city = city;
        this.cost = cost;
        this.stop = stop;
    }
}
class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        k = k + 1;
        Map<Integer, Set<State>> graph = new HashMap<>();
        for (int[] flight : flights) {
            int from = flight[0], to = flight[1], cost = flight[2];
            graph.putIfAbsent(from, new HashSet<>());
            graph.get(from).add(new State(to, cost, 0));
        }

        int[] minStopToCurrentCity = new int[n];
        Arrays.fill(minStopToCurrentCity, Integer.MAX_VALUE);

        PriorityQueue<State> heap = new PriorityQueue<>((a, b) -> a.cost - b.cost);
        heap.offer(new State(src, 0, 0));
        while (!heap.isEmpty()) {
            State current = heap.poll();
            if (current.stop > minStopToCurrentCity[current.city] || current.stop > k) {
                continue;
            }

            minStopToCurrentCity[current.city] = current.stop;
            if (current.city == dst) {
                return current.cost;
            }
            
            if (!graph.containsKey(current.city)) {
                continue;
            }
            for (State neighbor : graph.get(current.city)) {
                heap.offer(new State(neighbor.city, neighbor.cost + current.cost, current.stop + 1));
            }
        }
        return -1;
    }
}