/**
________
    ______
      ______
________________
            _____________
*/
class Solution {
    public int findMinArrowShots(int[][] points) {
        Arrays.sort(points, new Comparator<int[]>() {
            public int compare(int[] a, int[] b) {
                return Integer.compare(a[1], b[1]);
            }
        });
        
        int[] current = points[0];
        int result = 1;
        for (int i = 1; i < points.length; i++) {
            if (points[i][0] > current[1]) {
                result++;
                current = points[i];
            }
        }
        return result;
    }
}