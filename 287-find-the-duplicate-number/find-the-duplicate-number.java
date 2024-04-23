class Solution {
    public int findDuplicate(int[] nums) {
        int slow = 0, fast = 0;
        do {
            slow = nums[slow];
            fast = nums[nums[fast]];
        } while (slow != fast);

        int newHead = 0;
        do {
            newHead = nums[newHead];
            slow = nums[slow];
        } while (newHead != slow);

        return newHead;
    }
}