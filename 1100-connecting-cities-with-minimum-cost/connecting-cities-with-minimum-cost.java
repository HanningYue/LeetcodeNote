class Solution {
    public int minimumCost(int n, int[][] connections) {
        List<int[]>[] graph = buildGraph(n, connections);
        Prim prim = new Prim(graph);
        if (!prim.connected()) {
            return -1;
        }
        return prim.weightSum();
    }
    public List<int[]>[] buildGraph(int n, int[][] connections) {
        List<int[]>[] graph = new LinkedList[n];
        for (int i = 0; i < n; i++) {
            graph[i] = new LinkedList<>();
        }
        for (int[] connection : connections) {
            int vertexOne = connection[0] - 1;
            int vertexTwo = connection[1] - 1;
            int weight= connection[2];
            graph[vertexOne].add(new int[]{vertexOne, vertexTwo, weight});
            graph[vertexTwo].add(new int[]{vertexTwo, vertexOne, weight});
        }
        return graph;
    }
}
class Prim {
    PriorityQueue<int[]> pq;
    boolean[] inMST;
    int weightSum = 0;
    List<int[]>[] graph;
    public Prim(List<int[]>[] graph) {
        this.graph = graph;
        this.pq = new PriorityQueue<>((a, b) -> {
            return a[2] - b[2];
        });
        int n = graph.length;
        this.inMST = new boolean[n];
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