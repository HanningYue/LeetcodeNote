/*
Kruskal or Prim
Kruskal: Sorted First, use Union-find to find MST
Prim: Use optimized sorting data structure, such as PriorityQueue
*/
class Prim {
    boolean[] inMST;
    int weightSum = 0;
    List<int[]>[] graph;
    PriorityQueue<int[]> pq;
    public Prim (List<int[]>[] graph) {
        this.graph = graph;
        this.inMST = new boolean[graph.length];
        this.pq = new PriorityQueue<>((a, b) -> {
            return a[2] - b[2];
        });
        
        inMST[0] = true;
        cut(0);
        while (!pq.isEmpty()) {
            int[] edge = pq.poll();
            int to = edge[1];
            int weight = edge[2];
            if (inMST[to]) {
                continue;
            }
            inMST[to] = true;
            weightSum += weight;
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
    public boolean allConnected() {
        for (int i = 0; i < inMST.length; i++) {
            if (!inMST[i]) {
                return false;
            }
        }
        return true;
    }
}
class Solution {
    public int minCostConnectPoints(int[][] points) {
        List<int[]>[] graph = buildGraph(points.length, points);
        Prim prim = new Prim(graph);
        return prim.weightSum();
    }
    private List<int[]>[] buildGraph(int n, int[][] points) {
        List<int[]>[] graph = new LinkedList[n];
        for (int i = 0; i < n; i++) {
            graph[i] = new LinkedList<>();
        }
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                int ix = points[i][0], iy = points[i][1];
                int jx = points[j][0], jy = points[j][1];
                int weight = Math.abs(ix - jx) + Math.abs(iy - jy);
                graph[i].add(new int[]{i, j, weight});
                graph[j].add(new int[]{j, i, weight});
            }
        }
        return graph;
    }
}