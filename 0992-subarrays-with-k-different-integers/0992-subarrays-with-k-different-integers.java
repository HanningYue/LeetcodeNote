/*
1. Main() helper(nums, k) - helper(nums, k - 1);
The difference between these two numbers gives the count of subarrays with EXACTLY K distinct integers. This is because subarrays that have at most K-1 distinct integers are excluded from those that have at most K.

2. Fixed sliding window, k size
Map<Integer, Integer> map //Save {number, frequency}
When map size reaches k + 1, minus frequency, if frequency reaches 0, remove nums[slow]

3. result add window size for each index fast, because we are caluclating the subarray with at most K different integers.
This is because for every new element added by moving the fast pointer, all subarrays ending at fast and starting from any point between slow and fast are valid.
*/
class Solution {
    public int subarraysWithKDistinct(int[] nums, int k) {
        return helper(nums, k) - helper(nums, k - 1);
    }
    
    private int helper(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        
        int result = 0;
        int slow = 0;
        for (int fast = 0; fast < nums.length; fast++) {
            map.put(nums[fast], map.getOrDefault(nums[fast], 0) + 1);
            
            while (map.size() == k + 1) {
                map.put(nums[slow], map.get(nums[slow]) - 1);
                if (map.get(nums[slow]) == 0) {
                    map.remove(nums[slow]);
                }
                slow++;
            }
            
            result += fast - slow + 1;
        }
        return result;
    }
}