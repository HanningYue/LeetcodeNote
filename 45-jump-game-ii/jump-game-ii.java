class Solution {
    public int jump(int[] nums) {
        int end = 0, farthest = 0;
        int step = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            farthest = Math.max(i + nums[i], farthest);
            if (end == i) {
                step++;
                end = farthest;
            }
        }
        return step;
    }
}