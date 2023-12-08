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
    int[][] dirs = new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
    int minimumEffortPath(int[][] heights) {
        int m = heights.length, n = heights[0].length;
        int[][] effortTo = new int[m][n];
        for (int i = 0; i < m; i++) {
            Arrays.fill(effortTo[i], Integer.MAX_VALUE);
        }
        effortTo[0][0] = 0;

        Queue<State> pq = new PriorityQueue<>((a, b) -> {
            return a.effortFromStart - b.effortFromStart;
        });
        
        pq.offer(new State(0, 0, 0));

        while (!pq.isEmpty()) {
            State curState = pq.poll();
            int curX = curState.x;
            int curY = curState.y;
            int curEffortFromStart = curState.effortFromStart;
            
            if (curX == m - 1 && curY == n - 1) {
                return curEffortFromStart;
            }
            
            if (curEffortFromStart > effortTo[curX][curY]) {
                continue;
            }
            for (int[] neighbor : buildGraph(heights, curX, curY)) {
                int nextX = neighbor[0];
                int nextY = neighbor[1];
                int effortToNextNode = Math.max(
                    effortTo[curX][curY], 
                    Math.abs(heights[curX][curY] - heights[nextX][nextY])
                );
                if (effortTo[nextX][nextY] > effortToNextNode) {
                    effortTo[nextX][nextY] = effortToNextNode;
                    pq.offer(new State(nextX, nextY, effortToNextNode));
                }
            }
        }
        return -1;
    }
    public List<int[]> buildGraph(int[][] heights, int row, int col) {
        List<int[]> graph = new ArrayList<>();
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