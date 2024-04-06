class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>(); //value, index
        for (int i = 0; i < nums.length; i++) {
            int currentNum = nums[i];
            if (map.containsKey(currentNum)) {
                int prevIndex = map.get(currentNum);
                if (i - prevIndex <= k) {
                    return true;
                }
            }
            map.put(nums[i], i);
        }
        return false;
    }
}