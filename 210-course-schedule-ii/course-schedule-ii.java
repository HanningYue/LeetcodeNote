/**
VISITING VS. VISITED
1. Based on Course Schedule I, this question requires an int[] as return, 构图 as usual
2. We need an extra List<Integer> to keep track of the current order in dfs2
3. ATTENTION : check non-connected node and visted seperately, unlike Course Schedule I which checked jointly, because adding non-connected node in the list can be any order
*/
class Solution {
    boolean[] visited, onPath;
    boolean cycle = false;
    List<Integer> postOrder = new ArrayList<>();
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        List<Integer>[] graph = buildGraph(numCourses, prerequisites);
        onPath = new boolean[numCourses];
        visited = new boolean[numCourses];

        for (int i = 0; i < numCourses; i++) {
            traverse(graph, i);
        }
        if (cycle) {
            return new int[]{};
        }

        Collections.reverse(postOrder);
        int[] result = new int[numCourses];
        for (int i = 0; i < numCourses; i++) {
            result[i] = postOrder.get(i);
        }
        return result;
    }
    private void traverse(List<Integer>[] graph, int vertex) {
        if (onPath[vertex]) {
            cycle = true;
        }
        if (visited[vertex] || cycle) {
            return;
        }

        visited[vertex] = true;
        onPath[vertex] = true;
        for (int neighbor : graph[vertex]) {
            traverse(graph, neighbor);
        }
        postOrder.add(vertex);
        onPath[vertex] = false;
    }
    private List<Integer>[] buildGraph(int numCourses, int[][] prerequisites) {
        List<Integer>[] graph = new LinkedList[numCourses];
        for (int i = 0; i < numCourses; i++) {
            graph[i] = new LinkedList<>();
        }
        for (int[] edge : prerequisites) {
            int to = edge[0];
            int from = edge[1];
            graph[from].add(to);
        }
        return graph;
    }
}