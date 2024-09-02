class Solution {
    UF unionFind;
    public int[] findRedundantConnection(int[][] edges) {
        unionFind = new UF(edges.length + 1);
        for (int[] edge : edges) {
            if (unionFind.connected(edge[0], edge[1])) {
                return edge;
            }
            unionFind.union(edge[0], edge[1]);
        }
        return new int[]{};
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
    public void union(int p, int q) {
        if (find(p) == find(q)) {
            return;
        }
        int parentP = find(p);
        int parentQ = find(q);
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
        int parentP = find(p);
        int parentQ = find(q);
        return parentP == parentQ;
    }
}