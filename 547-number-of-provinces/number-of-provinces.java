class Solution {
    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;
        boolean[] visited = new boolean[n];
        Map<Integer, Set<Integer>> graph = new HashMap<>();
        for (int i = 0; i < n; i++) {
            graph.put(i, new HashSet<>());
            for (int j = 0; j < isConnected[i].length; j++) {
                if (isConnected[i][j] == 1) {
                    graph.get(i).add(j);
                }
            }
        }

        int count = 0;
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                dfs(graph, visited, i);
                count++;
            }
        }
        return count;
    }
    private void dfs(Map<Integer, Set<Integer>> graph, boolean[] visited, int vertex) {
        if (visited[vertex]) {
            return;
        }
        visited[vertex] = true;
        for (int neighbor : graph.get(vertex)) {
            dfs(graph, visited, neighbor);
        }
    }
}