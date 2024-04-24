class State {
    int cost, city, stop;
    public State(int cost, int city, int stop) {
        this.cost = cost;
        this.city = city;
        this.stop = stop;
    }
}
class Pair {
    int city, cost;
    public Pair(int city, int cost) {
        this.city = city;
        this.cost = cost;
    }
}
class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        k = k + 1;
        Map<Integer, Set<Pair>> graph = new HashMap<>();
        for (int[] flight : flights) {
            int from = flight[0], to = flight[1], cost = flight[2];
            graph.putIfAbsent(from, new HashSet<>());
            graph.get(from).add(new Pair(to, cost));
        }
        int[] minStop = new int[n];
        Arrays.fill(minStop, Integer.MAX_VALUE);

        PriorityQueue<State> heap = new PriorityQueue<>((a, b) -> a.cost - b.cost);
        heap.offer(new State(0, src, 0));

        while(!heap.isEmpty()) {
            State current = heap.poll();
            if (current.stop > minStop[current.city] || current.stop > k) {
                continue;
            }
            minStop[current.city] = current.stop;
            if (current.city == dst) {
                return current.cost;
            }

            if (!graph.containsKey(current.city)) {
                continue;
            }
            for (Pair pair : graph.get(current.city)) {
                heap.offer(new State(current.cost + pair.cost, pair.city, current.stop + 1));
            }
        }
        return -1;
    }
}