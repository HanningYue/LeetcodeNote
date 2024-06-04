class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int n = numCourses;
        int[] result = new int[n];
        boolean[] visited = new boolean[n];
        boolean[] visiting = new boolean[n];
        
        Map<Integer, Set<Integer>> graph = new HashMap<>();
        for (int[] pre : prerequisites) {
            int to = pre[0], from = pre[1];
            graph.putIfAbsent(to, new HashSet<>());
            graph.get(to).add(from);
        }
        
        List<Integer> order = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (!dfs(graph, visited, visiting, i, order)) {
                return new int[]{};
            }
        }
        for (int i = 0; i < order.size(); i++) {
            result[i] = order.get(i);
        }
        return result;
    }
    private boolean dfs(Map<Integer, Set<Integer>> graph, boolean[] visited, boolean[] visiting,
    int vertex, List<Integer> order) {
        if (visiting[vertex]) {
            return false;
        }
        if (visited[vertex]) {
            return true;
        }
        if (!graph.containsKey(vertex)) {
            order.add(vertex);
            visited[vertex] = true;
            return true;
        }
        visiting[vertex] = true;
        for (int neighbor : graph.get(vertex)) {
            if (!dfs(graph, visited, visiting, neighbor, order)) {
                return false;
            }
        }
        visited[vertex] = true;
        visiting[vertex] = false;
        order.add(vertex);
        return true;
    }
}