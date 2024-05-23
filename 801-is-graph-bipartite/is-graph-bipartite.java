class UF {
    int count;
    int[] parent;
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
    public boolean isBipartite(int[][] graph) {
        UF uf = new UF(graph.length);
        for (int i = 0; i < graph.length; i++) {
            for (int j = 0; j < graph[i].length; j++) {
                if (uf.connected(i, graph[i][j])) {
                    return false;
                }
                if (graph[i].length > 0) {
                    uf.union(graph[i][0], graph[i][j]);
                }
            }
        }
        return true;
    }
}