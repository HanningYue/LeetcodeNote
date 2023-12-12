/**
快慢指针，当快指针遇到慢指针相同的val，跳过
*/
class Solution {
    public int removeDuplicates(int[] nums) {
        int slow = 0, fast = 0;
        while (fast < nums.length) {
            if (nums[fast] != nums[slow]) {
                slow++;
                nums[slow] = nums[fast];
            }
            fast++;
        }
        return slow + 1;
    }
}