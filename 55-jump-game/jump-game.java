class Solution {
    public boolean canJump(int[] nums) {
        int furthest = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            furthest = Math.max(furthest, i + nums[i]);
            if (i == furthest) {
                return false;
            }
        }
        return furthest >= nums.length - 1;
    }
}
/*
[1, 0, 0]
0 1 2
1 1
  1
[1, 2, 3, 4, 5, 6]
 0  1  2  3  4  5
furthestIdx = 0 + 1 = 1
furthestIdx = 1 + 2 = 3
furthestIdx = 2 + 3 = 5
furthestIdx = 3 + 4 = 7
furthestIdx = 4 + 5 = 9
*/