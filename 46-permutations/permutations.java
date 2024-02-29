class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        Set<Integer> visited = new HashSet<>();
        dfs(result, list, visited, nums);
        return result;
    }
    private void dfs(List<List<Integer>> result, List<Integer> list, Set<Integer> visited, int[] nums)
    {
        if (list.size() == nums.length) {
            result.add(new ArrayList<>(list));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (visited.add(nums[i])) {
                list.add(nums[i]);
                dfs(result, list, visited, nums);
                list.remove(list.size() - 1);
                visited.remove(nums[i]);
            }
        }
    }
}