class Solution {
    private Map<String, Integer> memo;

    public int findTargetSumWays(int[] nums, int target) {
        memo = new HashMap<>();
        return dfs(nums, 0, 0, target);
    }
    
    private int dfs(int[] nums, int index, int currentSum, int target) {
        // Base case: if we've reached the end of the array
        if (index == nums.length) {
            if (currentSum == target) {
                return 1;  // Found a valid way
            }
            return 0;  // No valid way
        }
        
        // Memoization check
        String key = index + "," + currentSum;
        if (memo.containsKey(key)) {
            return memo.get(key);
        }
        
        // Calculate the number of ways by considering both adding and subtracting the current number
        int add = dfs(nums, index + 1, currentSum + nums[index], target);
        int subtract = dfs(nums, index + 1, currentSum - nums[index], target);
        
        // Store the result in the memoization table before returning
        memo.put(key, add + subtract);
        return memo.get(key);
    }
}
