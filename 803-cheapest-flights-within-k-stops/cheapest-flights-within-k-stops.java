class State {
    int cost;
    int city;
    int stops;
    public State(int cost, int city, int stops) {
        this.cost = cost;
        this.city = city;
        this.stops = stops;
    }
}
class Pair {
    int next;
    int cost;
    public Pair(int next, int cost) {
        this.next = next;
        this.cost = cost;
    }
}

class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        Map<Integer, List<Pair>> graph = new HashMap<>();
        for (int[] flight : flights) {
            int from = flight[0], to = flight[1], cost = flight[2];
            graph.putIfAbsent(from, new ArrayList<Pair>());
            graph.get(from).add(new Pair(to, cost));
        }

        int[] minStopToCity = new int[n];
        Arrays.fill(minStopToCity, Integer.MAX_VALUE);
        PriorityQueue<State> heap = new PriorityQueue<>((a, b) -> a.cost - b.cost);
        heap.offer(new State(0, src, 0));

        while (!heap.isEmpty()) {
            State current = heap.poll();
            int currentCost = current.cost;
            int currentCity = current.city;
            int currentStops = current.stops;

            if (currentStops > minStopToCity[currentCity] || currentStops > k + 1) {
                continue;
            }
            minStopToCity[currentCity] = currentStops;

            if (currentCity == dst) {
                return currentCost;
            }
            if (!graph.containsKey(currentCity)) {
                continue;
            }
            for (Pair pair : graph.get(currentCity)) {
                int nextCity = pair.next;
                int cost = pair.cost;
                heap.offer(new State(currentCost + cost, nextCity, currentStops + 1));
            }
        }
        return -1;
    }
}



















