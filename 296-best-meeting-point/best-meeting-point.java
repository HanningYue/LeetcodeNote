class Solution {
    public int minTotalDistance(int[][] grid) {
        List<Integer> xAxis = new ArrayList<>();
        List<Integer> yAxis = new ArrayList<>();
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    xAxis.add(i);
                    yAxis.add(j);
                }
            }
        }
        Collections.sort(xAxis);
        Collections.sort(yAxis);
        int xMedian = xAxis.get(xAxis.size() / 2);
        int yMedian = yAxis.get(yAxis.size() / 2);
        
        int xDistance = getDistance(xAxis, xMedian);
        int yDistance = getDistance(yAxis, yMedian);
        return xDistance + yDistance;
    }
    private int getDistance(List<Integer> axis, int median) {
        int distance = 0;
        for (int coor : axis) {
            distance += Math.abs(coor - median);
        }
        return distance;
    }
}