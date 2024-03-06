class Solution {
    public int maxPoints(int[][] points) {
        if (points == null || points.length == 0) {
            return 0;
        }

        int result = 0;
        for (int i = 0; i < points.length; i++) {
            Map<Double, Integer> map = new HashMap<>();
            int overlap = 0;
            int max = 0;
            
            for (int j = i + 1; j < points.length; j++) {
                int dx = points[j][0] - points[i][0];
                int dy = points[j][1] - points[i][1];

                if (dx == 0 && dy == 0) {
                    // Overlapping point
                    overlap++;
                    continue;
                }

                double slope = dx == 0 ? Double.MAX_VALUE : (double) dy / dx;
                if (dy == 0) {
                    // Horizontal line
                    slope = 0.0;
                }

                map.put(slope, map.getOrDefault(slope, 0) + 1);
                max = Math.max(max, map.get(slope));
            }
            result = Math.max(result, max + overlap + 1);
        }
        return result;
    }
}
