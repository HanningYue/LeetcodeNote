class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) {
            graph.add(new ArrayList<>());
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
    private boolean dfs(int vertex, List<List<Integer>> graph,boolean[] visiting, 
    boolean[] visited, List<Integer> order) {
        if (visiting[vertex]) {
            return false;
        }
        if (visited[vertex]) {
            return true;
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