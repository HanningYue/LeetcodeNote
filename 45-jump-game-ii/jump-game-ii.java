class Solution {
    public int jump(int[] nums) {
        int subFurthest = 0, furthest = 0;
        int step = 0;

        for (int i = 0; i < nums.length - 1; i++) {
            furthest = Math.max(furthest, nums[i] + i);
            if (i == subFurthest) {
                step++;
                subFurthest = furthest;
            }
        }
        return step;
    }
}