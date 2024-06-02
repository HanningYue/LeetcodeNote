class Uf {
    int countOfComponent;
    int[] parent;
    public Uf(int n) {
        this.countOfComponent = n;
        parent = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }
    }
    public int find(int a) {
        if (parent[a] != a) {
            parent[a] = find(parent[a]);
        }
        return parent[a];
    }
    public void union(int a, int b) {
        int parentA = find(a), parentB = find(b);
        if (parentA == parentB) {
            return;
        }

        parent[parentA] = parentB;
        countOfComponent--;
    }
    public boolean isConnected(int a, int b) {
        return find(a) == find(b);
    }
}

class Solution {
    int[][] directions = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    public List<Integer> numIslands2(int m, int n, int[][] positions) {
        List<Integer> result = new ArrayList<>();
    
        Set<Integer> visited = new HashSet<>();
        int count = 0;
        Uf uf = new Uf(m * n);

        for (int[] position : positions) {
            int currentRow = position[0], currentCol = position[1];
            int currentOneD = currentRow * n + currentCol;
            if (visited.add(currentOneD)) {
                count++;
                uf.parent[currentOneD] = currentOneD;

                for (int[] dir : directions) {
                    int newRow = dir[0] + currentRow;
                    int newCol = dir[1] + currentCol;
                    int newOneD = newRow * n + newCol;

                    if (newRow < 0 || newRow >= m || newCol < 0 || newCol >= n || !visited.contains(newOneD)) {
                        continue;
                    }
                    if (!uf.isConnected(currentOneD, newOneD)) {
                        uf.union(currentOneD, newOneD);
                        count--;
                    }
                }
            }
            result.add(count);
        }    
        return result;
    }
}