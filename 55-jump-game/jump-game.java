/**
To reach last index, we need to start from back, check each index forward can be reached
(READ THE ABOVE LINE AGAIN)
Use greedy, to 
*/
class Solution {
    public boolean canJump(int[] nums) {
        int endIndex = nums.length - 1;

        for (int i = nums.length - 2; i >= 0; i--) {
            if (nums[i] + i >= endIndex) {
                endIndex = i;
            }
        }
        return endIndex == 0;
    }
}