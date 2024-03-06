class Solution {
    public int maxPoints(int[][] points) {
        if (points.length == 0 || points == null) {
            return 0;
        }

        int result = 0;
        for (int i = 0; i < points.length; i++) {
            Map<Double, Integer> map = new HashMap<>(); //{slope, frequency}
            int overlap = 0;
            int max = 0;

            for (int j = i + 1; j < points.length; j++) {
                int diffX = points[j][0] - points[i][0];
                int diffY = points[j][1] - points[i][1];
                double slope;

                if (diffX == 0 && diffY == 0) {
                    overlap++;
                    continue;
                } else if (diffX == 0) {
                    slope = Double.MAX_VALUE;
                } else if (diffY == 0) {
                    slope = 0.0;
                } else {
                    slope = (double) diffY / diffX;
                }

                map.put(slope, map.getOrDefault(slope, 0) + 1);
                max = Math.max(max, map.get(slope));
            }
            result = Math.max(result, overlap + max + 1);
        }
        return result;
    }
}