class Solution {
    public int[] corpFlightBookings(int[][] bookings, int n) {
        int[] result = new int[n];
        int[] diff = Diff(new int[n]);
        for (int[] booking : bookings) {
            int left = booking[0] - 1;
            int right = booking[1] - 1;
            int val = booking[2];
            increment(diff, left, right, val);
        }
        result[0] = diff[0];
        for (int i = 1; i < diff.length; i++) {
            result[i] = result[i - 1] + diff[i];
        }
        return result;
    }
    private int[] Diff(int[] nums) {
        int[] diff = new int[nums.length];
        for (int i = 0; i < nums.length - 1; i++) {
            diff[i] = nums[i + 1] - nums[i];
        }
        return diff;
    }
    private void increment(int[] diff, int left, int right, int val) {
        diff[left] += val;
        if (right + 1 < diff.length) {
            diff[right + 1] -= val;
        }
    }
}