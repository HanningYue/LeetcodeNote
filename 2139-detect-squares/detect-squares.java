class DetectSquares {
    int[][] pointFreq;
    List<int[]> allPoints;
    public DetectSquares() {
        pointFreq = new int[1001][1001];
        allPoints = new ArrayList<>();
    }
    
    public void add(int[] point) {
        int x = point[0], y = point[1];
        pointFreq[x][y]++;
        allPoints.add(point);
    }
    
    public int count(int[] point) {
        int count = 0;
        int x = point[0], y = point[1];
        for (int[] diagonalPoint : allPoints) {
            int diagonalX = diagonalPoint[0];
            int diagonalY = diagonalPoint[1];
            if (Math.abs(diagonalX - x) == 0 || Math.abs(diagonalY - y) == 0 
            || Math.abs(diagonalX - x) != Math.abs(diagonalY - y)) {
                continue;
            }
    
            count += pointFreq[diagonalX][y] * pointFreq[x][diagonalY];
        }
        return count;
    }
}

/**
 * Your DetectSquares object will be instantiated and called as such:
 * DetectSquares obj = new DetectSquares();
 * obj.add(point);
 * int param_2 = obj.count(point);
 */