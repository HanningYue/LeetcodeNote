class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>(); //{currentnum, index}
        for (int i = 0; i < nums.length; i++) {
            int current = nums[i];
            if (map.containsKey(target - current)) {
                return new int[]{i, map.get(target - current)};
            }
            map.put(current, i);
        }
        return new int[]{-1, -1};
    }
}