class Solution {
    public int makeConnected(int n, int[][] connections) {
        if (connections.length < n - 1) {
            return -1;
        }

        Uf uf = new Uf(n);
        for (int[] connect : connections) {
            int vertexOne = connect[0], vertexTwo = connect[1];
            if (uf.connected(vertexOne, vertexTwo)) {
                continue;
            }
            uf.union(vertexOne, vertexTwo);
        }
        return uf.countOfComponent - 1;
    }
}
class Uf {
    int[] parent;
    int countOfComponent;
    public Uf(int n) {
        this.countOfComponent = n;
        parent = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }
    }
    public void union(int a, int b) {
        int parentA = find(a), parentB = find(b);
        if (parentA == parentB) {
            return;
        } else {
            parent[parentA] = parentB;
            countOfComponent--;
        }
    }
    public int find(int a) {
        if (parent[a] != a) {
            parent[a] = find(parent[a]);
        }
        return parent[a];
    }
    public boolean connected(int a, int b) {
        if (find(a) == find(b)) {
            return true;
        }
        return false;
    }
}