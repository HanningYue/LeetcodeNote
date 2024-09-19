class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        Map<Integer, List<Integer>> graph = new HashMap<>();
        for (int[] pre : prerequisites) {
            int from = pre[1], to = pre[0];
            graph.putIfAbsent(from, new ArrayList<>());
            graph.get(from).add(to);
        }

        boolean[] visited = new boolean[numCourses];
        boolean[] visiting = new boolean[numCourses];
        for (int i = 0; i < numCourses; i++) {
            if (!dfs(i, graph, visited, visiting)) {
                return false;
            }
        }
        return true;
    }
    private boolean dfs(int vertex, Map<Integer, List<Integer>> graph, boolean[] visited, 
    boolean[] visiting) {
        if (!graph.containsKey(vertex) || visited[vertex]) {
            return true;
        }
        if (visiting[vertex]) {
            return false;
        }
        visiting[vertex] = true;
        for (int neighbor : graph.get(vertex)) {
            if (!dfs(neighbor, graph, visited, visiting)) {
                return false;
            }
        }
        visiting[vertex] = false;;
        visited[vertex] = true;
        return true;
    }
}