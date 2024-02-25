class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        boolean[] visited = new boolean[numCourses];
        boolean[] visiting = new boolean[numCourses];
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0 ; i < numCourses; i++) {
            graph.add(new ArrayList<>());
        }
        for (int[] pre : prerequisites) {
            int from = pre[1];
            int to = pre[0];
            graph.get(from).add(to);
        }
        for (int i = 0; i < numCourses; i++) {
            if (!dfs(graph, i, visited, visiting)) {
                return false;
            }
        }
        return true;
    }
    private boolean dfs(List<List<Integer>> graph, int vertex, boolean[] visited, boolean[] visiting) {
        if (visiting[vertex]) {
            return false;
        }
        if (visited[vertex]) {
            return true;
        }
        visiting[vertex] = true;
        for (int neighbor : graph.get(vertex)) {
            if (!dfs(graph, neighbor, visited, visiting)) {
                return false;
            }
        }
        visiting[vertex] = false;
        visited[vertex] = true;
        return true;
    }
}