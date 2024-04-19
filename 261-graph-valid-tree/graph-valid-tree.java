class UF {
    int[] parent;
    int count;
    public UF(int numberOfNode) {
        this.count = numberOfNode;
        parent = new int[numberOfNode];
        for (int i = 0; i < numberOfNode; i++) {
            parent[i] = i;
        }
    }
    public int find(int vertex) {
        if (parent[vertex] != vertex) {
            parent[vertex] = find(parent[vertex]);
        }
        return parent[vertex];
    }
    public void union(int p, int q) {
        int parentP = find(p);
        int parentQ = find(q);
        if (parentQ == parentP) {
            return;
        }
        parent[parentP] = parentQ;
        count--;
    }
    public boolean connected(int p, int q) {
        return find(p) == find(q);
    }
}
class Solution {
    public boolean validTree(int n, int[][] edges) {
        UF uf = new UF(n);
        for (int[] edge : edges) {
            int vertexOne = edge[0];
            int vertexTwo = edge[1];
            if (uf.connected(vertexOne, vertexTwo)) {
                return false;
            }
            uf.union(vertexOne, vertexTwo);
        }
        return uf.count == 1;
    }
}