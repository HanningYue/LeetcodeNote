class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        boolean[] visited = new boolean[nums.length];
        backTrack(nums, result, list, 0, visited);
        return result;
    }
    private void backTrack(int[] nums, List<List<Integer>> result, List<Integer> list, int index, boolean[] visited) {
        if (list.size() == nums.length) {
            result.add(new ArrayList<>(list));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (visited[i]) {
                continue;
            }
            visited[i] = true;
            list.add(nums[i]);
            backTrack(nums, result, list, i + 1, visited);
            visited[i] = false;
            list.remove(list.size() - 1);
        }
    }
}