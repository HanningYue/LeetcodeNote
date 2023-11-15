/*
Floyd's Algorithm, LinkedList problem. Think values as pointers in nums, all value is a pointer to the index within the range of nums. Because [1, n]
1. Use fast and slow, while slow != fast. Hashing the nums[fast] in to nums. When fast = slow, Take a new int slow2, Redirect nums[slow2] and nums[slow] while slow ! slow2
2. When slow2 equals slow, return slow2;
//We found the start of the cycle -> New pointer starts at 0-index -> when new pointer reach slow pointer, it is the location of the duplicate number
*/
class Solution {
    public int findDuplicate(int[] nums) {
        int slow = 0;
        int fast = 0;
        
        do {
            fast = nums[nums[fast]];
            slow = nums[slow];
        }
        while (slow != fast);
        
        int newHead = 0;
        do {
            slow = nums[slow];
            newHead = nums[newHead];
        }
        while (slow != newHead);
        
        return slow;
    }
}