class Solution {
    public List<List<Integer>> permute(int[] nums) {
        boolean[] visited = new boolean[nums.length];
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        backTrack(nums, visited, result, list);
        return result;
    }
    private void backTrack(int[] nums, boolean[] visited,
    List<List<Integer>> result, List<Integer> list) {
        if (list.size() == nums.length) {
            result.add(new ArrayList<>(list));
        }
        for (int i = 0; i < nums.length; i++) {
            if (!visited[i]) {
                visited[i] = true;
                list.add(nums[i]);
                backTrack(nums, visited, result, list);
                list.remove(list.size() - 1);
                visited[i] = false;
            }
        }
    }
}