class Solution {
    public int maxPoints(int[][] points) {
        int globalMax = 0;

        for (int i = 0; i < points.length; i++) {
            Map<Double, Integer> slopeAndFreq = new HashMap<>();
            Double slope;
            int currentMax = 0;

            for (int j = i + 1; j < points.length; j++) {
                int diffX = points[j][0] - points[i][0];
                int diffY = points[j][1] - points[i][1];

                if (diffX == 0) {
                    slope = Double.MAX_VALUE;
                } else if (diffY == 0) {
                    slope = 0.0;
                } else {
                    slope = (double) diffY / diffX;
                }

                slopeAndFreq.put(slope, slopeAndFreq.getOrDefault(slope, 0) + 1);
                currentMax = Math.max(currentMax, slopeAndFreq.get(slope));
            }

            globalMax = Math.max(globalMax, currentMax + 1);
        }
        return globalMax;
    }
}