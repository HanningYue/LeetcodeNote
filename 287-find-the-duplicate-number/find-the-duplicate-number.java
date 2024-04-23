class Solution {
    public int findDuplicate(int[] nums) {
        int slow = 0, fast = 0;
        do {
            slow = nums[slow];
            fast = nums[nums[fast]];
        } while (slow != fast);
        
        int head = 0;
        do {
            head = nums[head];
            slow = nums[slow];
        } while (head != slow);

        return head;
    }
}