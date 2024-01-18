class Solution {
    public boolean carPooling(int[][] trips, int capacity) {
        int[] result = new int[1001];
        for (int[] trip : trips) {
            int val = trip[0];
            int left = trip[1];
            int right = trip[2] - 1;
            increase(result, left, right, val);
        }
        int currentCapacity = 0;
        for (int i = 0; i < result.length; i++) {
            currentCapacity += result[i];
            if (currentCapacity > capacity)
                return false;
        }
        return true;
    }

    private void increase(int[] result, int left, int right, int val) {
        result[left] += val;
        if (right + 1 < result.length) {
            result[right + 1] -= val;
        }
    }
}
