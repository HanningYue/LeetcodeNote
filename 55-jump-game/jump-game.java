/**
To reach last index, we need to start from back, check each index forward can be reached
(READ THE ABOVE LINE AGAIN)
Use greedy, if each index is reachable(>=) by previous index + nums[index], update index
*/
class Solution {
    public boolean canJump(int[] nums) {
        int furthest = nums.length - 1;
        for (int i = nums.length - 2; i >= 0; i--) {
            if (nums[i] + i >= furthest) {
                furthest = i;
            }
        }
        return furthest == 0;
    }
}