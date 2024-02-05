class UF {
    private int count;
    private int[] parent;
    public UF(int n) {
        this.count = n;
        parent = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }
    }
    public int find(int x) {
        if (parent[x] == x) {
            return x;
        }
        return find(parent[x]);
    }
    public void union(int p, int q) {
        int rootP = find(p);
        int rootQ = find(q);
        if (rootQ == rootP) {
            return;
        }
        parent[rootQ] = rootP;
        count--;
    }
    public boolean connected(int p, int q) {
        return find(p) == find(q);
    }
    public int count() {
        return count;
    }
}
class Solution {
    public int[] findRedundantConnection(int[][] edges) {
        UF uf = new UF(edges.length);
        for (int[] edge : edges) {
            int vertexOne = edge[0] - 1;
            int vertexTwo = edge[1] - 1;
            if (uf.connected(vertexOne, vertexTwo)) {
                return edge;
            }
            uf.union(vertexOne, vertexTwo);
        }
        return new int[]{};
    }
}