/*
Kruskal or Prim
Kruskal: Sorted First, use Union-find to find MST
Prim: Use optimized sorting data structure, such as PriorityQueue
*/
class Solution {
    public int minCostConnectPoints(int[][] points) {
        int n = points.length;
        List<int[]>[] graph = buildGraph(points);
        return new Prim(graph).weightSum();
    }
    private List<int[]>[] buildGraph(int[][] points) {
        List<int[]>[] graph = new LinkedList[points.length];
        for (int i = 0; i < points.length; i++) {
            graph[i] = new LinkedList<>();
        }
        for (int i = 0; i < points.length; i++) {
            for (int j = i + 1; j < points.length; j++) {
                int xi = points[i][0], yi = points[i][1];
                int xj = points[j][0], yj = points[j][1];
                int weight = Math.abs(xj - xi) + Math.abs(yj - yi);
                graph[i].add(new int[]{i, j, weight});
                graph[j].add(new int[]{j, i, weight});
            }
        }
        return graph;
    }
}
class Prim {
    boolean[] inMST;
    int weightSum = 0;
    PriorityQueue<int[]> pq;
    List<int[]>[] graph;
    public Prim(List<int[]>[] graph) {
        this.inMST = new boolean[graph.length];
        pq = new PriorityQueue<>((a, b) -> {
            return a[2] - b[2];
        });
        this.graph = graph;
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
    public void cut(int vertex) {
        for (int[] neighbor : graph[vertex]) {
            int to = neighbor[1];
            if (inMST[to]) {
                continue;
            }
            pq.offer(neighbor);
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