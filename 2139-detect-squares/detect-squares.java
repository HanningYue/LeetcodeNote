/**
Declear a 2D array to save points' frequency
Use an ArrayList to save all the points array
To find all the potential squares current point could form
    increase the frequency of the adding points, use a 2D array
    Iterate each array in allPoints
        Check the diagonal x-axis point and y-axis point, skip current array if distance between x and dx is 0
        Or the length is different from height
    Add the product of points frequency to result
*/
class DetectSquares {
    int[][] pointsFrequency;
    List<int[]> allPoints;

    public DetectSquares() {
        allPoints = new ArrayList<>();
        pointsFrequency = new int[1001][1001];
    }
    
    public void add(int[] point) {
        int x = point[0];
        int y = point[1];
        pointsFrequency[x][y]++;
        allPoints.add(point);
    }
    
    public int count(int[] point) {
        int x = point[0];
        int y = point[1];
        int result = 0;

        for (int[] diagonalPoint : allPoints) {
            int diagonalX = diagonalPoint[0];
            int diagonalY = diagonalPoint[1];
            if (Math.abs(diagonalX - x) == 0 || Math.abs(diagonalY - y) == 0 
            || Math.abs(diagonalX - x) != Math.abs(diagonalY - y)) {
                continue;
            }

            result += pointsFrequency[x][diagonalY] * pointsFrequency[diagonalX][y];
        }

        return result;
    }
}