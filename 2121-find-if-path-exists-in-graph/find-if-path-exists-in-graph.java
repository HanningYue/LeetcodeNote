class Solution {
    public boolean validPath(int n, int[][] edges, int source, int destination) {
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }
        for (int[] edge : edges) {
            int from = edge[0], to = edge[1];
            graph.get(from).add(to);
            graph.get(to).add(from);
        }        
        boolean[] visited = new boolean[n];
        return dfs(source, graph, destination, visited);
    }
    private boolean dfs(int vertex, List<List<Integer>> graph, int target, boolean[] visited) {
        if (vertex == target) {
            return true;
        }
        if (visited[vertex]) {
            return false;
        }
        visited[vertex] = true;
        for (int neighbor : graph.get(vertex)) {
            if (dfs(neighbor, graph, target, visited)) {
                return true;
            }
        }
        return false;
    }
}