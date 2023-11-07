/*
Two distinct indices i and j
1. Create a Set, to remove duplicate
2. Fixed Sliding window, maintain k size, WHEN I > K, remove the i - k - 1 (left-most element)
3. 
*/
class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        Set<Integer> set = new HashSet<>();
        int slow = 0;
        for (int fast = 0; fast < nums.length; fast++) {
            if (fast - slow > k) {
                set.remove(nums[slow]);
                slow++;
            }
            if (!set.add(nums[fast])) {
                return true;
            }
        }
        return false;
    }
}
