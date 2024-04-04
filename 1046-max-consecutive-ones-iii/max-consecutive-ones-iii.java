class Solution {
    public int longestOnes(int[] nums, int k) {
        int zeroCount = 0, result = 0;
        
        int slow = 0, fast = 0;
        while (fast < nums.length) {
            if (nums[fast] == 0) {
                zeroCount++;
            }
            
            while (zeroCount > k) {
                if (nums[slow] == 0) {
                    zeroCount--;
                }
                slow++;
            }

            result = Math.max(result, fast - slow + 1);
            fast++;
        }
        return result;
    }
}