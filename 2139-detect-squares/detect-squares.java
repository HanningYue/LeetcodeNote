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
        int currentX = point[0], currentY = point[1];
        for (int[] p : allPoints) {
            int diagX = p[0], diagY = p[1];
            int xDiff = Math.abs(currentX - diagX);
            int yDiff = Math.abs(currentY - diagY);
            if (xDiff == 0 ||  yDiff == 0 || xDiff != yDiff) {
                continue;
            }

            count += pointFreq[diagX][currentY] * pointFreq[currentX][diagY];
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