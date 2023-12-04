/*
PriorityQueue<> //{weight, node}
Set<> //Check duplicate
MST(minimum spanning tree) - Prim's Algorithm
想要找到最短的cost链接所有的point in a 2D ARRAY
We need to create out own edges, since each point can go to every other point
Apply Prim's Algo  O(n^2logn) 
1. BFS, use a minHeap, compare the 0-index(weight) of int[]
2. for each int[], {weight from start to current node, current node}
3. HashSet to check duplicate, check whether the currentNode is visited or not
4. For loop, calculate the distance between current node to all the rest nodes
*/
class Solution {
    public int minCostConnectPoints(int[][] points) {
        int n = points.length;
        List<int[]> edges = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                int xi = points[i][0], yi = points[i][1];
                int xj = points[j][0], yj = points[j][1];
                edges.add(new int[]{i, j, Math.abs(xi - xj) + Math.abs(yi - yj)});
            }
        }
        Collections.sort(edges, (a, b) -> {
            return a[2] - b[2];
        });
        
        UF uf = new UF(n);
        int mst = 0;
        for (int[] edge : edges) {
            int vertexOne = edge[0];
            int vertexTwo = edge[1];
            int weight = edge[2];
            if (uf.connected(vertexOne, vertexTwo)) {
                continue;
            }
            mst += weight;
            uf.union(vertexOne, vertexTwo);
        }
        return mst;
    }
}
class UF {
    int count;
    int[] parent;
    public UF(int n) {
        this.count = n;
        parent = new int[n];
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