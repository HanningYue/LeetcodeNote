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
    public int find(int vertex) {
        if (parent[vertex] != vertex) {
            parent[vertex] = find(parent[vertex]);
        }
        return parent[vertex];
    }
    public void union(int one, int two) {
        int parentOne = find(one);
        int parentTwo = find(two);
        if (parentOne == parentTwo) {
            return;
        }
        parent[parentOne] = parentTwo;
        count--;
    }
    public boolean connected(int one, int two) {
        return find(one) == find(two);
    }
}
class Solution {
    public int[] findRedundantConnection(int[][] edges) {
        int n = edges.length + 1;
        UnionFind uf = new UnionFind(n);
        for (int[] edge : edges) {
            int one = edge[0];
            int two = edge[1];
            if (uf.connected(one, two)) {
                return edge;
            }
            uf.union(one, two);
        }
        return new int[]{};
    }
}
