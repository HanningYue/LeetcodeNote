class Solution {
    public int jump(int[] nums) {
        int maxJumpAtEachStop = 0, furthest = 0;
        int step = 0;

        for (int currentStop = 0; currentStop < nums.length - 1; currentStop++) {
            maxJumpAtEachStop = Math.max(maxJumpAtEachStop, nums[currentStop] + currentStop);
            if (furthest == currentStop) {
                step++;               
                furthest = maxJumpAtEachStop;
            }
        }
        return step;
    }
}