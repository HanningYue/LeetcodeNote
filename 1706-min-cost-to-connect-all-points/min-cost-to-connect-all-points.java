/*
Kruskal or Prim
Kruskal: Sorted First, use Union-find to find MST
Prim: Use optimized sorting data structure, such as PriorityQueue
*/
class Solution {
    public int minCostConnectPoints(int[][] points) {
        List<int[]> edges = new ArrayList<>();
        int mst = 0;
        for (int i = 0; i < points.length; i++) {
            for (int j = i + 1; j < points.length; j++) {
                int xi = points[i][0], yi = points[i][1];
                int xj = points[j][0], yj = points[j][1];
                edges.add(new int[]{i, j, Math.abs(xi - xj) + Math.abs(yi - yj)});
            }
        }
        Collections.sort(edges, (a, b) -> {
            return a[2] - b[2];
        });
        UF uf = new UF(points.length);
        for (int[] edge : edges) {
            int vertexOne = edge[0];
            int vertexTwo = edge[1];
            int weight = edge[2];
            if (uf.connected(vertexOne, vertexTwo)) {
                continue;
            }
            mst += weight;
            uf.union(vertexOne, vertexTwo);
        }
        return mst;
    }
}
class UF{
    int count;
    int[] parent;
    public UF(int n) {
        parent = new int[n];
        this.count = n;
        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }
    }
    public int find(int x) {
        if (parent[x] != x) {
            parent[x] = find(parent[x]);
        }
        return parent[x];
    }
    public void union(int q, int p) {
        int rootQ = find(q);
        int rootP = find(p);
        if (rootQ == rootP) {
            return;
        }
        parent[rootP] = rootQ;
        count--;
    }
    public boolean connected(int q, int p) {
        int rootQ = find(q);
        int rootP = find(p);
        return rootQ == rootP;
    }
    public int count() {
        return count;
    }
}