class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        Map<Integer, Set<Integer>> graph = new HashMap<>();
        for (int[] pre : prerequisites) {
            int before = pre[1];
            int after = pre[0];
            graph.putIfAbsent(after, new HashSet<>());
            graph.get(after).add(before);
        }
        boolean[] visited = new boolean[numCourses];
        boolean[] visiting = new boolean[numCourses];
        for (int i = 0; i < numCourses; i++) {
            if (!dfs(graph, visited, visiting, i)) {
                return false;
            }
        }
        return true;
    }
    private boolean dfs(Map<Integer, Set<Integer>> graph, boolean[] visited, boolean[] visiting,
    int vertex) {
        if (visiting[vertex]) {
            return false;
        }
        if (!graph.containsKey(vertex)) {
            visited[vertex] = true;
            return true;
        }
        if (visited[vertex]) {
            return true;
        }
        visiting[vertex] = true;
        for (int neighbor : graph.get(vertex)) {
            if (!dfs(graph, visited, visiting, neighbor)) {
                return false;
            }
        }
        visiting[vertex] = false;
        visited[vertex] = true;
        return true;
    }
}