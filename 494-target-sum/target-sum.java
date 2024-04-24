class Solution {
    Map<String, Integer> dpTable;
    public int findTargetSumWays(int[] nums, int target) {
        dpTable = new HashMap<>();
        return dfs(nums, 0, 0, target);
    }
    private int dfs(int[] nums, int index, int currentSum, int target) {
        if (index == nums.length) {
            if (currentSum == target) {
                return 1;
            }
            return 0;
        }
        
        String key = index + "," + currentSum;
        if (dpTable.containsKey(key)) {
            return dpTable.get(key);
        }
        
        int add = dfs(nums, index + 1, currentSum + nums[index], target);
        int subtract = dfs(nums, index + 1, currentSum - nums[index], target);
        
        dpTable.put(key, add + subtract);
        return dpTable.get(key);
    }
}
