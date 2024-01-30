class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        boolean[] visited = new boolean[nums.length];
        backTrack(nums, result, list, visited);
        return result;
    }
    private void backTrack(int[] nums, List<List<Integer>> result, List<Integer> list, boolean[] visited) {
        if (list.size() == nums.length) {
            result.add(new ArrayList<>(list));
            return;
        }
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            if (visited[i] || !set.add(nums[i])) {
                continue;
            }
            list.add(nums[i]);
            visited[i] = true;
            backTrack(nums, result, list, visited);
            visited[i] = false;
            list.remove(list.size() - 1);
        }
    }
}