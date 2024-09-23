class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        backTrack(nums, 0, result, list);
        return result;
    }
    private void backTrack(int[] nums, int index, List<List<Integer>> result, List<Integer> list) {
        result.add(new ArrayList<>(list));
        for (int i = index; i < nums.length; i++) {
            if (i > index && nums[i] == nums[i - 1]) {
                continue;
            }
            list.add(nums[i]);
            backTrack(nums, i + 1, result, list);
            list.remove(list.size() - 1);
        }
    }
}