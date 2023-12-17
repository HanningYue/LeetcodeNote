class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        boolean[] visiting = new boolean[numCourses];
        boolean[] visited = new boolean[numCourses];
        List<Integer>[] graph = new LinkedList[numCourses];
        List<Integer> order = new ArrayList<>();

        for (int i = 0; i < numCourses; i++) {
            graph[i] = new LinkedList<>();
        }
        for (int[] pre : prerequisites) {
            int from = pre[1];
            int to = pre[0];
            graph[from].add(to);
        }
        for (int i = 0; i < numCourses; i++) {
            if (!traverse(i, visiting, visited, order, graph)) {
                return new int[]{};
            }
        }

        int[] result = new int[numCourses];
        Collections.reverse(order);
        for (int i = 0; i < numCourses; i++) {
            result[i] = order.get(i);
        }
        return result;
    }
    private boolean traverse(int vertex, boolean[] visiting, boolean[] visited,
    List<Integer> order, List<Integer>[] graph) {
        if (visited[vertex]) {
            return true;
        }
        if (visiting[vertex]) {
            return false;
        }
        visiting[vertex] = true;
        for (int neighbor : graph[vertex]) {
            if (!traverse(neighbor, visiting, visited, order, graph)) {
                return false;
            }
        }
        visiting[vertex] = false;
        visited[vertex] = true;
        order.add(vertex);
        return true;
    }
}