class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        backtracking(nums, result, list, 0);
        return result;
    }
    private void backtracking(int[] nums, List<List<Integer>> result, List<Integer> list, int level) {
        result.add(new ArrayList<>(list));
        for (int i = level; i < nums.length; i++) {
            list.add(nums[i]);
            backtracking(nums, result, list, i + 1);
            list.remove(list.size() - 1);
        }
    }
}