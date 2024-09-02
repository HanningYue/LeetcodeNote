class Solution {
    UnionFind uf;
    public int[] findRedundantConnection(int[][] edges) {
        uf = new UnionFind(edges.length + 1);
        for (int[] edge : edges) {
            if (uf.connected(edge[0], edge[1])) {
                return edge;
            }
            uf.union(edge[0], edge[1]);
        }
        return new int[]{};
    }
}
class UnionFind {
    int[] parent;
    int count;
    public UnionFind(int n) {
        this.count = n;
        parent = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }
    }
    public void union(int p, int q) {
        int parentP = find(p);
        int parentQ = find(q);
        if (parentP == parentQ) {
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
    public boolean connected(int p, int q) {
        return find(p) == find(q);
    }
}