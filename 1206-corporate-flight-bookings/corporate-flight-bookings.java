class Solution {
    public int[] corpFlightBookings(int[][] bookings, int n) {
        int[] result = new int[n];
        for (int[] booking : bookings) {
            int from = booking[0] - 1;
            int to = booking[1] - 1;
            int val = booking[2];
            increase(result, from, to, val);
        }
        for (int i = 1; i < result.length; i++) {
            result[i] += result[i - 1];
        }
        return result;
    }
    private void increase(int[] result, int left, int right, int val) {
        result[left] += val;
        if (right + 1 < result.length) {
            result[right + 1] -= val;
        }
    }
}