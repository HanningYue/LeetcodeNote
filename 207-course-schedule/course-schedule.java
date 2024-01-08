class Solution {
    private boolean[] visited;
    private boolean[] visiting;
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) {
            graph.add(new ArrayList<>());
        }
        visited = new boolean[numCourses];
        visiting = new boolean[numCourses];
        for (int[] pre : prerequisites) {
            int from = pre[1];
            int to = pre[0];
            graph.get(from).add(to);
        }
        for (int i = 0; i < numCourses; i++) {
            if (!dfs(graph, i)) {
                return false;
            }
        }
        return true;
    }
    private boolean dfs(List<List<Integer>> graph, int vertex) {
        if (visited[vertex]) {
            return true;
        }
        if (visiting[vertex]) {
            return false;
        }
        visiting[vertex] = true;
        for (int neighbor : graph.get(vertex)) {
            if (!dfs(graph, neighbor)) {
                return false;
            }
        }
        visiting[vertex] = false;
        visited[vertex] = true;
        return true;
    }
}