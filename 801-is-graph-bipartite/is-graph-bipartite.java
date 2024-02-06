class Solution {
    public boolean isBipartite(int[][] graph) {
        UF uf = new UF(graph.length * 2); // Extend the number of vertices to 2 times
        for (int u = 0; u < graph.length; u++) {
            int parentU = uf.find(u); // Find the set of u
            for (int v : graph[u]) {
                if (parentU == uf.find(v)) return false; // u and v are in the same set
                uf.union(u + graph.length, v); // Union u's opposite set with v
            }
        }
        return true;
    }
}

class UF {
    private int[] parent;

    public UF(int n) {
        parent = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }
    }

    public int find(int x) {
        if (x != parent[x]) {
            parent[x] = find(parent[x]); // Path compression
        }
        return parent[x];
    }

    public void union(int x, int y) {
        int rootX = find(x);
        int rootY = find(y);
        if (rootX != rootY) {
            parent[rootX] = rootY; // Union the roots
        }
    }

    public boolean connected(int x, int y) {
        return find(x) == find(y);
    }
}
