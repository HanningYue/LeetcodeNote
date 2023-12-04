class Solution {
    public boolean validTree(int n, int[][] edges) {
        UF uf = new UF(n);
        for (int[] edge : edges) {
            int vertexOne = edge[0];
            int vertexTwo = edge[1];
            if (uf.connected(vertexOne, vertexTwo)) {
                return false;
            }
            uf.union(vertexOne, vertexTwo);
        }
        return uf.count() == 1;
    }
}
class UF {
    int count;
    int[] parent;
    public UF (int n) {
        this.count = n;
        parent = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }
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
    public int find(int x) {
        if (parent[x] != x) {
            parent[x] = find(parent[x]);
        }
        return parent[x];
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