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

        int count = 0;
        Set<Integer> visited = new HashSet<>();
        for (int vertex : graph.keySet()) {
            if (visited.contains(vertex)) {
                continue;
            }
            count++;
            dfs(vertex, graph, visited);
        }
        return count;
    }

    private void dfs(int vertex, Map<Integer, Set<Integer>> graph, Set<Integer> visited) {
        if (visited.contains(vertex)) {
            return;
        }
        visited.add(vertex);
        for (int neighbor : graph.get(vertex)) {
            dfs(neighbor, graph, visited);
        }
    }
}