class Solution {
    public boolean carPooling(int[][] trips, int capacity) {
        int[] result = new int[1001];
        for (int[] trip : trips) {
            int val = trip[0];
            int from = trip[1];
            int to = trip[2] - 1;
            increase(result, from, to, val);
        }
        if (result[0] > capacity) {
            return false;
        }
        for (int i = 1; i < result.length; i++) {
            result[i] += result[i - 1];
            if (result[i] > capacity) {
                return false;
            }
        }
        return true;
    }
    private void increase(int[] nums, int left, int right, int val) {
        nums[left] += val;
        if (right + 1 < nums.length) {
            nums[right + 1] -= val;
        }
    }
}