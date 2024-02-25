class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        boolean[] visiting = new boolean[numCourses];
        boolean[] visited = new boolean[numCourses];
        List<Integer> result = new ArrayList<>();
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) {
            graph.add(new ArrayList<>());
        }
        for (int[] pre : prerequisites) {
            int from = pre[0];
            int to = pre[1];
            graph.get(from).add(to);
        }
        for (int i = 0; i < numCourses; i++) {
            if (!dfs(graph, i, visiting, visited, result)) {
                return new int[]{};
            }
        }
        int[] resultArr = new int[numCourses];
        for (int i = 0; i < numCourses; i++) {
            resultArr[i] = result.get(i);
        }
        return resultArr;
    }
    private boolean dfs(List<List<Integer>> graph, int vertex, boolean[] visiting, boolean[] visited, List<Integer> result) {
        if (visiting[vertex]) {
            return false;
        }
        if (visited[vertex]) {
            return true;
        }
        visiting[vertex] = true;
        for (int neighbor : graph.get(vertex)) {
            if (!dfs(graph, neighbor, visiting, visited, result)) {
                return false;
            }
        }
        visiting[vertex] = false;
        visited[vertex] = true;
        result.add(vertex);
        return true;
    }
}