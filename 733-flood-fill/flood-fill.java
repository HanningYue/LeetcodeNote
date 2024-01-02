class Solution {
  public int[][] floodFill(int[][] matrix, int x, int y, int newColor) {
    Queue<int[]> queue = new LinkedList<>();
    queue.offer(new int[]{x, y});
    int[][] directions = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    boolean[][] visited = new boolean[matrix.length][matrix[0].length];
    int originalColor = matrix[x][y];
    matrix[x][y] = newColor;

    while (!queue.isEmpty()) {
      int[] current = queue.poll();
      for (int[] dir : directions) {
        int row = current[0] + dir[0];
        int col = current[1] + dir[1];
        if (row < 0 || row >= matrix.length || col < 0 || col >= matrix[0].length 
        || matrix[row][col] != originalColor || visited[row][col]) {
          continue;
        }
        visited[row][col] = true;
        queue.offer(new int[]{row, col});
        matrix[row][col] = newColor;
      }
    }
    return matrix;
  }
}