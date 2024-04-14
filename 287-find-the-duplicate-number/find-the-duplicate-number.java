class Solution {
    public int findDuplicate(int[] nums) {
        int slow = 0, fast = 0;
        do {
            slow = nums[slow];
            fast = nums[nums[fast]];
        } while (slow != fast);

        int duplicate = 0;
        do {
            duplicate = nums[duplicate];
            slow = nums[slow];
        } while (duplicate != slow);

        return duplicate;
    }
}