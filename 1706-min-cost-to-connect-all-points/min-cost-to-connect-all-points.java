/*
Kruskal or Prim
Kruskal: Sorted First, use Union-find to find MST
Prim: Use optimized sorting data structure, such as PriorityQueue
*/
class Solution {
    public int minCostConnectPoints(int[][] points) {
        List<int[]> edges = new ArrayList<>();
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
        int mst = 0;
        UF uf = new UF(points.length);
        for (int[] edge : edges) {
            int vertexOne = edge[0];
            int vertexTwo = edge[1];
            int weight = edge[2];
            if (uf.connected(vertexOne, vertexTwo)) {
                continue;
            }
            uf.union(vertexOne, vertexTwo);
            mst += weight;
        }
        return mst;
    }
}
class UF {
    int count;
    int[] parent;
    public UF(int x) {
        this.count = x;
        parent = new int[x];
        for (int i = 0; i < x; i++) {
            parent[i] = i;
        }
    }
    public int find(int x) {
        if (parent[x] != x) {
            parent[x] = find(parent[x]);
        }
        return parent[x];
    }
    public void union(int p, int q) {
        int rootP = find(p);
        int rootQ = find(q);
        if (rootP == rootQ) {
            return;
        }
        parent[rootP] = rootQ;
    }
    public boolean connected(int p, int q) {
        int rootP = find(p);
        int rootQ = find(q);
        return rootP == rootQ;
    }
    public int count() {
        return count;
    }
}