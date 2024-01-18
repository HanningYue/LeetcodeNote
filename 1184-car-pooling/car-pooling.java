class Solution {
    public boolean carPooling(int[][] trips, int capacity) {
        int[] result = new int[1000];
        for (int[] trip : trips) {
            int val = trip[0];
            int from = trip[1];
            int to = trip[2] - 1;
            increase(result, from, to, val);    
        }
        int runningCapacity = 0;
        for (int i = 0; i < result.length; i++) {
            runningCapacity += result[i];
            if (runningCapacity > capacity)
                return false;
        }
        return true;
    }
    private void increase(int[] result, int left, int right, int val) {
        result[left] += val;
        if (right + 1 < result.length)
            result[right + 1] -= val;
    }
}