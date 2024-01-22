class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
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
        List<Integer> order = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) {
            if (!dfs(i, graph, visiting, visited, order)) {
                return new int[]{};
            }
        }
        Collections.reverse(order);
        int[] result = new int[numCourses];
        for (int i = 0; i < order.size(); i++) {
            result[i] = order.get(i);
        }
        return result;
    }
    private boolean dfs(int vertex, Map<Integer, List<Integer>> graph, 
    boolean[] visiting, boolean[] visited, List<Integer> order) {
        if (visited[vertex]) {
            return true;
        }
        if (visiting[vertex]) {
            return false;
        }
        visiting[vertex] = true;
        for (int neighbor : graph.get(vertex)) {
            if (!dfs(neighbor, graph, visiting, visited, order)) {
                return false;
            }
        }
        visiting[vertex] = false;
        visited[vertex] = true;
        order.add(vertex);
        return true;
    }
}