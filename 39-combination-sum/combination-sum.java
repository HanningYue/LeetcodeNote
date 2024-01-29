class Solution {
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        backTrack(nums, target, result, list, 0, 0);
        return result;
    }
    private void backTrack(int[] nums, int target, List<List<Integer>> result, List<Integer> list, 
    int index, int runningSum) 
    {
        if (runningSum == target) {
            result.add(new ArrayList<>(list));
        }
        if (runningSum > target) {
            return;
        }
        for (int i = index; i < nums.length; i++) {
            list.add(nums[i]);
            runningSum += nums[i];
            backTrack(nums, target, result, list, i, runningSum);
            runningSum -= nums[i];
            list.remove(list.size() - 1);
        }
    }
}