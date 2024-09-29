class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        double[] times = new double[target];

        for (int i = 0; i < position.length; i++) {
            times[position[i]] = (double)(target - position[i]) / speed[i];
        }

        int result = 0;
        double currentTime = 0;
        for (int i = target - 1; i >= 0; i--) {
            if (times[i] > currentTime) {
                result++;
                currentTime = times[i];
            }
        }
        return result;
    }
}