/*
Kruskal or Prim
Kruskal: Sorted First, use Union-find to find MST
Prim: Use optimized sorting data structure, such as PriorityQueue
*/
class Solution {
    public int minCostConnectPoints(int[][] points) {
        int n = points.length;
        List<int[]>[] graph = buildGraph(n, points);
        return new Prime(graph).weightSum();
    }
    public List<int[]>[] buildGraph(int n, int[][] points) {
        List<int[]>[] graph = new LinkedList[n];
        for (int i = 0; i < n; i++) {
            graph[i] = new LinkedList<>();
        }
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                int xi = points[i][0], yi = points[i][1];
                int xj = points[j][0], yj = points[j][1];
                int weight = Math.abs(xi - xj) + Math.abs(yi - yj);
                graph[i].add(new int[]{i, j, weight});
                graph[j].add(new int[]{j, i, weight});
            }
        }
        return graph;
    }
}
class Prime {
    PriorityQueue<int[]> pq;
    boolean[] inMST;
    List<int[]>[] graph;
    int weightSum = 0;

    public Prime(List<int[]>[] graph) {
        this.graph = graph;
        this.pq = new PriorityQueue<>((a, b) -> {
            return a[2] - b[2];
        });
        this.inMST = new boolean[graph.length];
        inMST[0] = true;
        cut(0);
        while (!pq.isEmpty()) {
            int[] edge = pq.poll();
            int to = edge[1];
            int weight = edge[2];
            if (inMST[to]) {
                continue;
            }
            weightSum += weight;
            inMST[to] = true;
            cut(to);
        }
    }
    private void cut(int vertex) {
        for (int[] edge : graph[vertex]) {
            int to = edge[1];
            if (inMST[to]) {
                continue;
            }
            pq.offer(edge);
        }
    }
    public int weightSum() {
        return weightSum;
    }
    public boolean connected() {
        for (int i = 0; i < inMST.length; i++) {
            if (!inMST[i]) {
                return false;
            }
        }
        return true;
    }
}