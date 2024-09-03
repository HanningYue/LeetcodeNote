class Solution {
    public int maxPoints(int[][] points) {
        int result = 0;
        for (int i = 0; i < points.length; i++) {
            Map<Double, Integer> slopeFreq = new HashMap<>();
            int localMaxPoint = 0;
            Double slope;

            for (int j = i + 1; j < points.length; j++) {
                int diffX = points[j][0] - points[i][0];
                int diffY = points[j][1] - points[i][1];

                if (diffY == 0) {
                    slope = 0.0;
                } else if (diffX == 0) {
                    slope = Double.MAX_VALUE;
                } else {
                    slope = (double) diffY / diffX;
                }

                slopeFreq.put(slope, slopeFreq.getOrDefault(slope, 0) + 1);
                localMaxPoint = Math.max(localMaxPoint, slopeFreq.get(slope));
            }
            result = Math.max(result, localMaxPoint + 1);
        }
        return result;
    }
}