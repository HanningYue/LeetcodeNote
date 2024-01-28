class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        boolean[] visited = new boolean[nums.length];
        backTrack(nums, list, result, visited);
        return result;
    }
    private void backTrack(int[] nums, List<Integer> list, List<List<Integer>> result, 
    boolean[] visited)
    {
        if (list.size() == nums.length) {
            result.add(new ArrayList<>(list));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (!visited[i]) {
                list.add(nums[i]);
                visited[i] = true;
                backTrack(nums, list, result, visited);
                visited[i] = false;
                list.remove(list.size() - 1);
            }
        }
    }
}