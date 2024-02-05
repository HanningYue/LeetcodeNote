class Solution {
    private boolean bipartite = true;
    public boolean possibleBipartition(int n, int[][] dislikes) {
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }
        for (int[] dislike : dislikes) {
            int personA = dislike[0] - 1;
            int personB = dislike[1] - 1;
            graph.get(personA).add(personB);
            graph.get(personB).add(personA);
        }
        boolean[] visited = new boolean[n];
        boolean[] color = new boolean[n];
        for (int i = 0; i < n; i++) {
            checkBipartite(i, graph, visited, color);
        }
        if (bipartite) {
            return true;
        }
        return false;
    }
    private void checkBipartite(int vertex, List<List<Integer>> graph, 
    boolean[] visited, boolean[] color) 
    {
        if (!bipartite) {
            return;
        }
        visited[vertex] = true;
        for (int neighbor : graph.get(vertex)) {
            if (!visited[neighbor]) {
                color[neighbor] = !color[vertex];
                checkBipartite(neighbor, graph, visited, color);
            } 
            else {
                if (color[vertex] == color[neighbor]) {
                    bipartite = false;
                    return;
                }
            }
        }
    }
}