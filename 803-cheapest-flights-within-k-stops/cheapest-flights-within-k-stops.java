class Solution {
    public int findCheapestPrice(int numCities, int[][] flights, int source, int destination, int maxStops) {
        // Adjacency list to hold the graph representation
        Map<Integer, List<int[]>> flightGraph = new HashMap<>();
        for (int[] flight : flights) {
            int from = flight[0];
            int to = flight[1];
            int cost = flight[2];
            flightGraph.computeIfAbsent(from, key -> new ArrayList<>()).add(new int[] {to, cost});
        }

        // Array to track the smallest number of stops to reach each node
        int[] stopsToNode = new int[numCities];
        Arrays.fill(stopsToNode, Integer.MAX_VALUE);
        
        // Priority queue to hold current state during the search
        PriorityQueue<int[]> queue = new PriorityQueue<>(new Comparator<int[]>() {
            public int compare(int[] o1, int[] o2) {
                return Integer.compare(o1[0], o2[0]);
            }
        });
        // Array format: {cost from source, current node, number of stops from source}
        queue.offer(new int[] {0, source, 0});

        while (!queue.isEmpty()) {
            int[] currentState = queue.poll();
            int currentCost = currentState[0];
            int currentNode = currentState[1];
            int currentStops = currentState[2];
            
            // Check if current path is longer in stops than a known shorter path
            if (currentStops > stopsToNode[currentNode] || currentStops > maxStops + 1) {
                continue;
            }
            stopsToNode[currentNode] = currentStops;
            
            // Destination check
            if (currentNode == destination) {
                return currentCost;
            }

            // Avoid NPE and unnecessary processing if no further paths
            if (!flightGraph.containsKey(currentNode)) {
                continue;
            }
            
            // Explore neighbors
            for (int[] neighbor : flightGraph.get(currentNode)) {
                int nextNode = neighbor[0];
                int travelCost = neighbor[1];
                queue.offer(new int[] {currentCost + travelCost, nextNode, currentStops + 1});
            }
        }
        return -1;
    }
}
