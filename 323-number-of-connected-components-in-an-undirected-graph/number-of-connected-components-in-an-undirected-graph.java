class Solution {
    public int countComponents(int n, int[][] edges) {
        Map<Integer, Set<Integer>> graph = new HashMap<>();
        for (int i = 0; i < n; i++) {
            graph.put(i, new HashSet<>());
        }
        for (int[] edge : edges) {
            graph.get(edge[0]).add(edge[1]);
            graph.get(edge[1]).add(edge[0]);
        }

        boolean[] visited = new boolean[n];
        int count = 0;
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                dfs(graph, i, visited);
                count++;
            }
        }
        return count;
    }
    private void dfs(Map<Integer, Set<Integer>> graph, int vertex, boolean[] visited) {
        if (visited[vertex]) {
            return;
        }
        
        visited[vertex] = true;
        for (int neighbor : graph.get(vertex)) {
            dfs(graph, neighbor, visited);
        }
    }
}