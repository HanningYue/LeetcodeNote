class UnionFind {
    int count;
    int[] parent;
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
        if (parentQ != parentP) {
            parent[parentP] = parentQ;
            count--;
        }
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
class Solution {
    public boolean validTree(int n, int[][] edges) {
        if (edges.length != n - 1) {
            return false;
        }
        UnionFind uf = new UnionFind(n);
        for (int[] edge : edges) {
            int from = edge[0], to = edge[1];
            if (uf.connected(from, to)) {
                return false;
            }
            uf.union(from, to);
        }
        return true;
    }
}