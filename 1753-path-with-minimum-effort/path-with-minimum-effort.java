class State {
    int x, y;
    int effortFromStart;
    public State(int x, int y, int effortFromStart) {
        this.x = x;
        this.y = y;
        this.effortFromStart = effortFromStart;
    }
}
class Solution {
    public int minimumEffortPath(int[][] heights) {
        int[][] distTo = new int[heights.length][heights[0].length];
        for (int i = 0; i < heights.length; i++) {
            Arrays.fill(distTo[i], Integer.MAX_VALUE);
        }
        distTo[0][0] = 0;

        dijkstra(heights, distTo);

        return distTo[heights.length - 1][heights[0].length - 1];
    }

    private void dijkstra(int[][] heights, int[][] distTo) {
        PriorityQueue<State> pq = new PriorityQueue<>((a, b) -> {
            return a.effortFromStart - b.effortFromStart;
        });
        pq.offer(new State(0, 0, 0));

        while (!pq.isEmpty()) {
            State state = pq.poll();
            int currentX = state.x;
            int currentY = state.y;
            int currentEffort = state.effortFromStart;
            if (currentEffort > distTo[currentX][currentY]) {
                continue;
            }

            for (int[] neighbor : buildGraph(heights, currentX, currentY)) {
                int nextX = neighbor[0];
                int nextY = neighbor[1];
                int nextEffort = Math.max(currentEffort, 
                    Math.abs(heights[currentX][currentY] - heights[nextX][nextY]));
                
                if (distTo[nextX][nextY] > nextEffort) {
                    distTo[nextX][nextY] = nextEffort;
                    pq.offer(new State(nextX, nextY, nextEffort));
                }
            }
        }
    }

    private List<int[]> buildGraph(int[][] heights, int row, int col) {
        List<int[]> graph = new ArrayList<>();
        int[][] dirs = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        for (int[] dir : dirs) {
            int x = row + dir[0];
            int y = col + dir[1];
            if (x >= 0 && x < heights.length && y >= 0 && y < heights[0].length) {
                graph.add(new int[]{x, y});
            }
        }
        return graph;
    }
}