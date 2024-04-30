class UnionFind {
    int[] parent;
    int count;
    public UnionFind(int n) {
        parent = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }
        this.count = n;
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
    public int countComponents(int n, int[][] edges) {
        UnionFind uf = new UnionFind(n);
        for (int[] edge : edges) {
            if (uf.connected(edge[0], edge[1])) {
                continue;
            }
            uf.union(edge[0], edge[1]);
        }
        return uf.count;
    }
}
