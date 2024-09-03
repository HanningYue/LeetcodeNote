class Solution {
    UnionFind uf;
    public int countComponents(int n, int[][] edges) {
        int count = 0;
        uf = new UnionFind(n);
        for (int[] edge : edges) {
            uf.union(edge[0], edge[1]);
        }
        return uf.count;
    }
}
class UnionFind {
    int count;
    int[] parent;
    public UnionFind (int n) {
        parent = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }
        this.count = n;
    }
    public void union(int p, int q) {
        int parentP = find(p);
        int parentQ = find(q);
        if (parentQ == parentP) {
            return;
        }
        parent[parentP] = parentQ;
        count--;
    }
    public int find(int p) {
        if (parent[p] != p) {
            parent[p] = find(parent[p]);
        }
        return parent[p];
    }
    public boolean isConnected(int p, int q) {
        return find(p) == find(q);
    }
}