class Solution {
    public boolean carPooling(int[][] trips, int capacity) {
        Diff diff = new Diff(new int[1001]);
        for (int[] trip : trips) {
            int from = trip[1];
            int to = trip[2] - 1;
            int value = trip[0];
            diff.increase(from, to, value);
        }        
        int[] result = diff.result();
        for (int i = 0; i < result.length; i++) {
            if (result[i] > capacity) {
                return false;
            }
        }
        return true;
    }
}
class Diff {
    private int[] diff;
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
            res[i] = diff[i] + res[i - 1];
        }
        return res;
    }
}