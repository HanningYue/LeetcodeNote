class UF {
    private int count;
    private int[] parent;
    public UF(int numberOfVertex) {
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
        if (parentOne != parentTwo) {
            parent[parentOne] = parentTwo;
            count--;
        }
    }
    public boolean connected(int vertexOne, int vertexTwo) {
        return find(vertexOne) == find(vertexTwo);
    }
    public int count() {
        return count;
    }
}
class Solution {
    public int[] findRedundantConnection(int[][] edges) {
        UF uf = new UF(edges.length);
        for (int[] edge : edges) {
            int start = edge[0] - 1;
            int end = edge[1] - 1;
            if (uf.connected(start, end)) {
                return edge;
            }
            uf.union(start, end);
        }
        return new int[]{};
    }
}