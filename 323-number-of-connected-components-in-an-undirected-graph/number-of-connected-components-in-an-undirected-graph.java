class Solution {
    public int countComponents(int n, int[][] edges) {
        UF uf = new UF(n);
        for (int[] edge : edges) {
            int vertexOne = edge[0];
            int vertexTwo = edge[1];
            if (uf.connected(vertexOne, vertexTwo)) {
                continue;
            }
            uf.union(vertexOne, vertexTwo);
        }
        return uf.count();
    }
}
class UF {
    int[] parent;
    int count;
    public UF(int n) {
        this.count = n;
        parent = new int[n];
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
    public void union(int p, int q) {
        int rootP = find(p);
        int rootQ = find(q);
        if (rootP == rootQ) {
            return;
        }
        parent[rootP] = rootQ;
        count--;
    }
    public int count() {
        return count;
    }
    public boolean connected(int p, int q) {
        int rootP = find(p);
        int rootQ = find(q);
        return rootP == rootQ;
    }
}