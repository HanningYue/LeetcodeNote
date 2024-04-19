public class Solution {
    public boolean validTree(int n, int[][] edges) {
        Map<Integer, Set<Integer>> graph = new HashMap<>();
        for (int i = 0; i < n; i++) {
            graph.put(i, new HashSet<>());
        }
        for (int[] edge : edges) {
            graph.get(edge[0]).add(edge[1]);
            graph.get(edge[1]).add(edge[0]);
        }

        Set<Integer> visited = new HashSet<>();
        Set<Integer> visiting = new HashSet<>();
        
        if (!dfs(0, visited, visiting, graph, -1)) {
            return false;
        }
        
        
        return visited.size() == n;
    }

    private boolean dfs(int vertex, Set<Integer> visited, Set<Integer> visiting, 
                        Map<Integer, Set<Integer>> graph, int parent) {
        if (visiting.contains(vertex)) {
            return false;
        }
        if (visited.contains(vertex)) {
            return true;
        }

        visiting.add(vertex);
        for (int neighbor : graph.get(vertex)) {
            if (neighbor != parent && !dfs(neighbor, visited, visiting, graph, vertex)) {
                return false;
            }
        }
        visited.add(vertex);
        visiting.remove(vertex);
        return true;
    }
}
