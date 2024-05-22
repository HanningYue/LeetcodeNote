class Solution {
    public int findMinArrowShots(int[][] points) {
        Arrays.sort(points, new Comparator<int[]>() {
            public int compare(int[] a, int[] b) {
                return Integer.compare(a[1], b[1]);
            }
        });
        
        int count = 1;
        int[] previousInterval = points[0];
        for (int i = 1; i < points.length; i++) {
            if (points[i][0] > previousInterval[1]) {
                count++;
                previousInterval = points[i];
            }
        }
        return count;
    }
}