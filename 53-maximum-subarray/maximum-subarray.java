// class Solution {
//     public int maxSubArray(int[] nums) {
//         int runningSum = 0;
//         int result = Integer.MIN_VALUE;
//         for (int num : nums) {
//             if (runningSum < 0) {
//                 runningSum = 0;
//             }
//             runningSum += num;
//             result = Math.max(result, runningSum);
//         }
//         return result;
//     }
// }
class Solution {
    public int maxSubArray(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        int[] dpTable = new int[nums.length];
        dpTable[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            dpTable[i] = Math.max(nums[i], nums[i] + dpTable[i - 1]);
        }

        int result = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            result = Math.max(result, dpTable[i]);
        }
        return result;
    }
}