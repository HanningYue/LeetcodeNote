/*
0 2 2 5 5 3 3 0
      3      -3
9        -2
0 1 2 3 4 5 6 7
[2 1 5]
[3 3 7]
*/
class Solution {
    public boolean carPooling(int[][] trips, int capacity) {
        int[] result = new int[1001];
        for (int[] trip : trips) {
            int value = trip[0];
            int from = trip[1];
            int to = trip[2];
            prefix(result, from, to, value);
        }
        if (result[0] > capacity) {
            return false;
        }
        for (int i = 1; i < result.length; i++) {
            result[i] = result[i] + result[i - 1];
            if (result[i] > capacity) {
                return false;
            }
        }
        return true;
    }
    private void prefix(int[] nums, int left, int right, int value) {
        nums[left] += value;
        if (right < nums.length) {
            nums[right] -= value;
        }
    }
}