class Solution {
    public int largestAltitude(int[] gain) {
        int currentAltitude = 0; // To store the current altitude during iteration
        int maxAltitude = 0; // To store the maximum altitude encountered

        // Iterate through the gain array, updating the current and max altitudes
        for(int i : gain) {
            currentAltitude += i;
            maxAltitude = Math.max(currentAltitude, maxAltitude);
        }

        return maxAltitude;
    }
}