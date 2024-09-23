class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        Map<Integer, List<Integer>> graph = new HashMap<>();
        for (int i = 0; i < numCourses; i++) {
            graph.put(i, new ArrayList<>());
        }
        for (int[] pre : prerequisites) {
            int from = pre[1];
            int to = pre[0];
            graph.get(from).add(to);
        }
        boolean[] visiting = new boolean[numCourses];
        boolean[] visited = new boolean[numCourses];
        for (int i = 0; i < numCourses; i++) {
            if (!dfs(i, visiting, visited, graph)) {
                return false;
            }
        }
        return true;
    }
    private boolean dfs(int vertex, boolean[] visiting, boolean[] visited, Map<Integer, List<Integer>> graph) {
        if (visiting[vertex]) {
            return false;
        }
        if (visited[vertex]) {
            return true;
        }
        visiting[vertex] = true;
        for (int neighbor : graph.get(vertex)) {
            if (!dfs(neighbor, visiting, visited, graph)) {
                return false;
            }
        }
        visited[vertex] = true;
        visiting[vertex] = false;
        return true;
    }
}