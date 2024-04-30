class Solution {
    public int findCircleNum(int[][] isConnected) {
        int count = 0;
        Set<Integer> visited = new HashSet<>();
        for (int i = 0; i < isConnected.length; i++) {
            if (!visited.contains(i)) {
                count++;
                bfs(i, isConnected, visited);
            }
        }        
        return count;
    }

    private void bfs(int vertex, int[][] isConnected, Set<Integer> visited) {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(vertex);

        while (!queue.isEmpty()) {
            int city = queue.poll();
            for (int i = 0; i < isConnected.length; i++) {
                if(isConnected[city][i] == 1 && !visited.contains(i)) {
                    queue.offer(i);
                    visited.add(i);
                }
            }
        }
    }
}