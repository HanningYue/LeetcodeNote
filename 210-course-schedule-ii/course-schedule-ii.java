class Solution {
    private boolean[] visiting;
    private boolean[] visited;
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        visiting = new boolean[numCourses];
        visited = new boolean[numCourses];
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) {
            graph.add(new ArrayList<>());
        }
        for (int[] pre : prerequisites) {
            int from = pre[1];
            int to = pre[0];
            graph.get(from).add(to);
        }
        List<Integer> order = new ArrayList<>();
        int[] result = new int[numCourses];
        for (int i = 0; i < numCourses; i++) {
            if (!dfs(graph, i, order)) {
                return new int[]{};
            }
        }
        Collections.reverse(order);
        for (int i = 0; i < order.size(); i++) {
            result[i] = order.get(i);
        }
        return result;
    }
    private boolean dfs(List<List<Integer>> graph, int vertex, List<Integer> order) {
        if (visiting[vertex]) {
            return false;
        }
        if (visited[vertex]) {
            return true;
        }
        visiting[vertex] = true;
        for (int neighbor : graph.get(vertex)) {
            if (!dfs(graph, neighbor, order)) {
                return false;
            }
        }
        visiting[vertex] = false;
        visited[vertex] = true;
        order.add(vertex);
        return true;
    }
}