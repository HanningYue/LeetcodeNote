class Solution {
    public int countComponents(int n, int[][] edges) {
        UnionFind uf = new UnionFind(n);
        for (int[] edge : edges) {
            int vertexOne = edge[0], vertexTwo = edge[1];
            if (uf.connected(vertexOne, vertexTwo)) {
                continue;
            }
            uf.union(vertexOne, vertexTwo);
        }
        return uf.count;
    }
}
class UnionFind {
    int[] parent;
    int count;
    public UnionFind(int numberOfVertex) {
        this.count = numberOfVertex;
        parent = new int[numberOfVertex];
        for (int i = 0; i < numberOfVertex; i++) {
            parent[i] = i;
        }
    }
    public int find(int vertex) {
        if (parent[vertex] != vertex) {
            parent[vertex] = find(parent[vertex]);
        }
        return parent[vertex];
    }
    public void union(int vertexOne, int vertexTwo) {
        int parentOne = find(vertexOne);
        int parentTwo = find(vertexTwo);
        if (parentOne == parentTwo) {
            return;
        }
        parent[parentOne] = parentTwo;
        count--;
    }
    public boolean connected(int vertexOne, int vertexTwo) {
        return find(vertexOne) == find(vertexTwo);
    }
}