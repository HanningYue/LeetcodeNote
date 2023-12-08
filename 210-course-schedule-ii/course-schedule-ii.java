/**
在第一题的基础上加入一个list来存拓扑序
要reverse因为我们构图的方式是从前到后
*/
class Solution {
    boolean[] onPath, visited;
    boolean cycle = false;
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        List<Integer> order = new ArrayList<>();
        List<Integer>[] graph = buildGraph(numCourses, prerequisites);
        onPath = new boolean[numCourses];
        visited = new boolean[numCourses];
        for (int i = 0; i < numCourses; i++) {
            traverse(graph, i, order);
        }
        if (cycle) {
            return new int[]{};
        }
        Collections.reverse(order);
        int[] result = new int[numCourses];
        for (int i = 0; i < numCourses; i++) {
            result[i] = order.get(i);
        }
        return result;
    }
    private void traverse(List<Integer>[] graph, int vertex, List<Integer> order) {
        if (onPath[vertex]) {
            cycle = true;
        }
        if (cycle || visited[vertex]) {
            return;
        }
        visited[vertex] = true;
        onPath[vertex] = true;
        for (int neighbor : graph[vertex]) {
            traverse(graph, neighbor, order);
        }
        order.add(vertex);
        onPath[vertex] = false;
    }
    private List<Integer>[] buildGraph(int numCourses, int[][] prerequisites) {
        List<Integer>[] graph = new LinkedList[numCourses];
        for (int i = 0; i < numCourses; i++) {
            graph[i] = new LinkedList<>();
        }
        for (int[] pre : prerequisites) {
            int from = pre[1];
            int to = pre[0];
            graph[from].add(to);
        }
        return graph;
    }
}