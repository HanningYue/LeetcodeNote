class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        Set<Integer> set = new HashSet<>();
        int slow = 0, fast = 0;
        while (fast < nums.length) {
            while (!set.add(nums[fast])) {
                if (fast - slow <= k) {
                    return true;
                }
                set.remove(nums[slow]);
                slow++;
            }
            set.add(nums[fast]);
            fast++;
        }
        return false;
    }
}