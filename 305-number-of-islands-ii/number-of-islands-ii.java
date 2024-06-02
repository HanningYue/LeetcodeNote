class Solution {
    int[][] directions = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    public List<Integer> numIslands2(int m, int n, int[][] positions) {
        List<Integer> result = new ArrayList<>();
        
        Uf uf = new Uf(m * n);
        int count = 0;
        for (int[] position : positions) {
            int currentRow = position[0], currentCol = position[1];
            int currentOneD = currentRow * n + currentCol;

            if (uf.parent[currentOneD] == -1) {
                uf.parent[currentOneD] = currentOneD;
                count++;

                for (int[] dir : directions) {
                    int newRow = dir[0] + currentRow, newCol = dir[1] + currentCol;
                    int newOneD = newRow * n + newCol;

                    if (newRow < 0 || newRow >= m || newCol < 0 || newCol >= n || uf.parent[newOneD] == -1) {
                        continue;
                    }
                    if (!uf.isConnected(newOneD, currentOneD)) {
                        uf.union(newOneD, currentOneD);
                        count--;
                    }
                }
            }
            result.add(count);
        }
        return result;
    }
}
class Uf {
    int[] parent;
    public Uf(int n) {
        parent = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = -1;
        }
    }
    public int find(int a) {
        if (parent[a] != a) {
            parent[a] = find(parent[a]);
        }
        return parent[a];
    }
    public void union(int a, int b) {
        if (find(a) == find(b)) {
            return;
        }
        int parentA = find(a), parentB = find(b);
        parent[parentA] = parentB;
    }
    public boolean isConnected(int a, int b) {
        return find(a) == find(b);
    }
}
