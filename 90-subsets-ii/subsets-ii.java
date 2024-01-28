class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        backTrack(nums, list, result, 0);
        return result;
    }
    private void backTrack(int[] nums, List<Integer> list, List<List<Integer>> result, int index) {
        result.add(new ArrayList<>(list));

        for (int i = index; i < nums.length; i++) {
            if (i > index && nums[i] == nums[i - 1]) {
                continue;
            }
            list.add(nums[i]);
            backTrack(nums, list, result, i + 1);
            list.remove(list.size() - 1);
        }
    }
}