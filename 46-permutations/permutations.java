/**
        1       23
    123 123
123 123 123
*/
class Solution {
    public List<List<Integer>> permute(int[] nums) {
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
        for (int i = 0; i < nums.length; i++) {
            if (visited[i]) {
                continue;
            }
            list.add(nums[i]);
            visited[i] = true;
            backTrack(nums, result, list, visited);
            list.remove(list.size() - 1);
            visited[i] = false;
        }
    }
}