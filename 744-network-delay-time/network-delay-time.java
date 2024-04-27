class State {
    int node, time;
    public State(int node, int time) {
        this.node = node;
        this.time = time;
    }
}

class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        Map<Integer, Set<State>> graph = new HashMap<>();
        for (int i = 1; i <= n; i++) {
            graph.put(i, new HashSet<>());
        }
        for (int[] time : times) {
            int source = time[0], target = time[1], cost = time[2];
            graph.get(source).add(new State(target, cost));
        }

        PriorityQueue<State> heap = new PriorityQueue<>((a, b) -> a.time - b.time);
        heap.offer(new State(k, 0));

        int[] minTimeToNode = new int[n + 1];
        Arrays.fill(minTimeToNode, Integer.MAX_VALUE);
        minTimeToNode[k] = 0;

        while (!heap.isEmpty()) {
            State current = heap.poll();

            for (State neighbor : graph.get(current.node)) {
                int newTime = current.time + neighbor.time;
                if (newTime < minTimeToNode[neighbor.node]) {
                    minTimeToNode[neighbor.node] = newTime;
                    heap.offer(new State(neighbor.node, newTime));
                }
            }
        }

        int maxTime = 0;
        for (int i = 1; i <= n; i++) {
            if (minTimeToNode[i] == Integer.MAX_VALUE) {
                return -1;
            }
            maxTime = Math.max(maxTime, minTimeToNode[i]);
        }
        return maxTime;
    }
}
