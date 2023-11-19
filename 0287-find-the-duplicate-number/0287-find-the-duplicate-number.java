class Solution {
    public int findDuplicate(int[] nums) {
        int slowPointer = 0;
        int fastPointer = 0;
        
        do {
            slowPointer = nums[slowPointer];
            fastPointer = nums[nums[fastPointer]];
        }
        while (slowPointer != fastPointer);
        
        int newPointer = 0;
        do {
            newPointer = nums[newPointer];
            slowPointer = nums[slowPointer];
        }
        while (newPointer != slowPointer);
        
        return newPointer;
    }
}