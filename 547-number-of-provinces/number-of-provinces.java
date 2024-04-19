class Solution {
    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;
        int count = 0;
        Set<Integer> visited = new HashSet<>();

        for (int i = 0; i < n; i++) {
            if (visited.contains(i)) {
                continue;
            }        
            dfs(isConnected, i, visited);
            count++;
        }
        return count;
    }
    private void dfs(int[][] isConnected, int vertex, Set<Integer> visited) {
        if (visited.contains(vertex)) {
            return;
        }
        visited.add(vertex);
        for (int i = 0; i < isConnected.length; i++) {
            if (isConnected[vertex][i] == 1) {
                dfs(isConnected, i, visited);
            }
        }
    }
}