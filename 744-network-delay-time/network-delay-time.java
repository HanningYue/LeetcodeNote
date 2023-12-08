/**
加权有向图，没有负权重边，OK，可以用 Dijkstra 算法计算最短路径。
求从起始点k到距离最远的vertex的最短路径
*/
class State {
    int id;
    int distFromStart;
    public State(int id, int distFromStart) {
        this.id = id;
        this.distFromStart = distFromStart;
    }
}
class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        int result = 0;
        List<int[]>[] graph = buildGraph(times, n);
        int[] distTo = dijkstra(graph, k);
        
        for (int i = 1; i < distTo.length; i++) {
            if (distTo[i] == Integer.MAX_VALUE) {
                return -1;
            }
            result = Math.max(result, distTo[i]);
        }
        return result;
    }

    public List<int[]>[] buildGraph(int[][] times, int n) {
        List<int[]>[] graph = new LinkedList[n + 1];
        for (int i = 1; i <= n; i++) {
            graph[i] = new LinkedList<>();
        }
        for (int[] time : times) {
            int from = time[0];
            int to = time[1];
            int weight = time[2];
            graph[from].add(new int[]{to, weight});
        }
        return graph;
    }

    public int[] dijkstra(List<int[]>[] graph, int start) {
        int[] distTo = new int[graph.length];
        Arrays.fill(distTo, Integer.MAX_VALUE);
        distTo[start] = 0;
        PriorityQueue<State> pq = new PriorityQueue<>((a, b) -> {
            return a.distFromStart - b.distFromStart;
        });
        pq.offer(new State(start, 0));
        
        while (!pq.isEmpty()) {
            State state = pq.poll();
            int currentNode = state.id;
            int currentDist = state.distFromStart;
            if (currentDist > distTo[currentNode]) {
                continue;
            }
            
            for (int[] neighbor : graph[currentNode]) {
                int nextNode = neighbor[0];
                int nextDist = currentDist + neighbor[1];
                if (distTo[nextNode] > nextDist) {
                    distTo[nextNode] = nextDist;
                    pq.offer(new State(nextNode, nextDist));
                }
            }
        }
        return distTo;
    }
}