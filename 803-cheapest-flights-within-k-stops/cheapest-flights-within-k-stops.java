class State {
    int cost, node, stops;
    public State(int cost, int node, int stops) {
        this.cost = cost;
        this.node = node;
        this.stops = stops;
    }
}

class Solution {
    public int findCheapestPrice(int numCities, int[][] flights, int source, int destination, int maxStops) {
        Map<Integer, List<int[]>> graph = new HashMap<>();
        for (int[] flight : flights) {
            int from = flight[0];
            int to = flight[1];
            int cost = flight[2];            
            graph.putIfAbsent(from, new ArrayList<>());
            graph.get(from).add(new int[]{to, cost});
        }
        
        int[] minStopsToNode = new int[numCities];
        Arrays.fill(minStopsToNode, Integer.MAX_VALUE);        
        PriorityQueue<State> queue = new PriorityQueue<>(new Comparator<State>() {
            public int compare(State a, State b) {
                return a.cost - b.cost;
            }
        });
        queue.offer(new State(0, source, 0));

        while (!queue.isEmpty()) {
            State currentState = queue.poll();
            int currentCost = currentState.cost;
            int currentNode = currentState.node;
            int currentStops = currentState.stops;
            
            if (currentStops > minStopsToNode[currentNode] || currentStops > maxStops + 1) {
                continue;
            }
            minStopsToNode[currentNode] = currentStops;
            if (currentNode == destination) {
                return currentCost;
            }

            if (!graph.containsKey(currentNode)) {
                continue;
            }            
            for (int[] neighbor : graph.get(currentNode)) {
                int nextNode = neighbor[0];
                int travelCost = neighbor[1];
                queue.offer(new State(currentCost + travelCost, nextNode, currentStops + 1));
            }
        }
        return -1;
    }
}
