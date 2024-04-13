/**
        2           3           6           7
    2 3 6 7        367          67          7
*/
class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        backTrack(result, list, candidates, target, 0, 0);
        return result;
    }
    private void backTrack(List<List<Integer>> result, List<Integer> list, int[] nums, int target, 
    int runningSum, int index) {
        if (runningSum == target) {
            result.add(new ArrayList<>(list));
            return;
        }
        if (runningSum > target) {
            return;
        }
        for (int i = index; i < nums.length; i++) {
            list.add(nums[i]);
            runningSum += nums[i];
            backTrack(result, list, nums, target, runningSum, i);
            runningSum -= nums[i];
            list.remove(list.size() - 1);
        }
    }
}