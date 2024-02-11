class Solution {
    public int[] corpFlightBookings(int[][] bookings, int n) {
        Diff diff = new Diff(new int[n]);
        for (int[] booking : bookings) {
            int from = booking[0] - 1;
            int to = booking[1] - 1;
            int value = booking[2];
            diff.increase(from, to, value);
        }        
        return diff.result();
    }
}
class Diff {
    int[] diff;
    public Diff(int[] nums) {
        diff = new int[nums.length];
        diff[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            diff[i] = nums[i] - nums[i - 1];
        }
    }
    public void increase(int left, int right, int value) {
        diff[left] += value;
        if (right + 1 < diff.length) {
            diff[right + 1] -= value;
        }
    }
    public int[] result() {
        int[] res = new int[diff.length];
        res[0] = diff[0];
        for (int i = 1; i < diff.length; i++) {
            res[i] = res[i - 1] + diff[i];
        }
        return res;
    }
}