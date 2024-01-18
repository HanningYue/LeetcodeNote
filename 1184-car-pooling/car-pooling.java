class Solution {
    public boolean carPooling(int[][] trips, int capacity) {
        int[] diff = new int[1001];
        for (int[] trip : trips) {
            int val = trip[0];
            int left = trip[1];
            int right = trip[2]; // Note the change here
            increase(diff, left, right, val);
        }
        int currentCapacity = 0;
        for (int i = 0; i < diff.length; i++) {
            currentCapacity += diff[i];
            if (currentCapacity > capacity)
                return false;
        }
        return true;
    }

    private void increase(int[] diff, int left, int right, int val) {
        diff[left] += val;
        if (right < diff.length) { // Adjust the condition here
            diff[right] -= val;
        }
    }
}
