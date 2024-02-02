class Solution {
    public int[] corpFlightBookings(int[][] bookings, int n) {
        int[] result = new int[n];
        for (int[] booking : bookings) {
            int from = booking[0] - 1;
            int to = booking[1] - 1;
            int value = booking[2];
            prefix(result, from, to, value);
        }
        for (int i = 1; i < result.length; i++) {
            result[i] = result[i] + result[i - 1];
        }
        return result;
    }
    private void prefix(int[] nums, int left, int right, int value) {
        nums[left] += value;
        if (right + 1 < nums.length) {
            nums[right + 1] -= value;
        }
    }
}