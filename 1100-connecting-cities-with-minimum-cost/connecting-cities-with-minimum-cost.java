class Solution {
    public int minimumCost(int n, int[][] connections) {
        UF uf = new UF(n + 1);
        Arrays.sort(connections, (a, b) -> (a[2] - b[2]));
        int mst = 0;

        for (int[] connection : connections) {
            int vertexOne = connection[0];
            int vertexTwo = connection[1];
            int weight = connection[2];

            if (uf.connected(vertexOne, vertexTwo)) {
                continue;
            }
            uf.union(vertexOne, vertexTwo);
            mst += weight;
        }
        return uf.count() == 2 ? mst : -1;
    }
}
class UF {
    int count;
    int[] parent;
    public UF(int n) {
        parent = new int[n];
        this.count = n;
        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }
    }
    public int find(int x) {
        if (parent[x] != x) {
            parent[x] = find(parent[x]);
        }
        return parent[x];
    }
    public void union(int p, int q) {
        int rootP = find(p);
        int rootQ = find(q);
        if (rootP == rootQ) {
            return;
        }
        parent[rootP] = rootQ;
        count--;
    }
    public boolean connected(int p, int q) {
        int rootP = find(p);
        int rootQ = find(q);
        return rootP == rootQ;
    }
    public int count() {
        return count;
    }
}