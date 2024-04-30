class Solution {
    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;

        UnionFind uf = new UnionFind(n);
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (isConnected[i][j] == 1) {
                    int vertexOne = i, vertexTwo = j;
                    if (uf.connected(vertexOne, vertexTwo)) {
                        continue;
                    }
                    uf.union(vertexOne, vertexTwo);
                }
            }
        }
        return uf.count;
    }
}
class UnionFind {
    int[] parent;
    int count;
    public UnionFind(int n) {
        parent = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
            this.count = n;
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