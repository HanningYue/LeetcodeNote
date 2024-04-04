class Solution {
    public int jump(int[] nums) {
        int furthest = 0;
        int subFurthest = 0, step = 0;

        for (int i = 0; i < nums.length - 1; i++) {
            furthest = Math.max(furthest, i + nums[i]);
            if (i == subFurthest) {
                subFurthest = furthest;
                step++;
            }
        }

        return step;
    }
}