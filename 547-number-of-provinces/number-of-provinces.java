class Solution {
    public int findCircleNum(int[][] isConnected) {
        UF uf = new UF(isConnected.length);
        for (int i = 0; i < isConnected.length; i++) {
            for (int j = i + 1; j < isConnected.length; j++) {
                if (isConnected[i][j] == 1) {
                    uf.union(i, j);
                }
            }
        }
        return uf.count;
    }
}
class UF {
    int[] parent;
    int count;
    public UF(int numberOfVertex) {
        parent = new int[numberOfVertex];
        this.count = numberOfVertex;
        for (int i = 0; i < numberOfVertex; i++) {
            parent[i] = i;
        }
    }
    public int find(int vertex) {
        if (parent[vertex] == vertex) {
            return vertex;
        }
        return find(parent[vertex]);
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