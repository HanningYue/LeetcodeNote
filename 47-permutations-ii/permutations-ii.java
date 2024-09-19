class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        boolean[] visited = new boolean[nums.length];
        backTrack(result, list, nums, visited);
        return result;
    }
    private void backTrack(List<List<Integer>> result, List<Integer> list, int[] nums, boolean[] visited) {
        if (list.size() == nums.length) {
            result.add(new ArrayList<>(list));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (visited[i]) {
                continue;
            }
            if (i > 0 && nums[i - 1] == nums[i] && visited[i - 1]) {
                continue;
            }
            visited[i] = true;
            list.add(nums[i]);
            backTrack(result, list, nums, visited);
            list.remove(list.size() - 1);
            visited[i] = false;
        }
    }
}