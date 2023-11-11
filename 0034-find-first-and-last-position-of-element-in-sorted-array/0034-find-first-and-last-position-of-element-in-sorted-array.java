/*
We want to return the starting and ending index of the given target number in nums.
1. Binary Search, since the array is sorted, let 左边界为0 右边界为nums.length
    when left < right, 检查中边界与target-number的比较(< , > or ==)
2. 我们想要返还
        
*/
class Solution {
    public int[] searchRange(int[] nums, int target) {
        int low = 0;
        int high = nums.length - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (nums[mid] > target) {
                high = mid - 1;
            } else if (nums[mid] < target) {
                low = mid + 1;
            } else {
                int tempMidLeft = mid;
                int tempMidRight = mid;
                while (tempMidLeft > 0 && nums[tempMidLeft - 1] == target) {
                    tempMidLeft--;
                }
                while (tempMidRight < nums.length - 1 && nums[tempMidRight + 1] == target) {
                    tempMidRight++;
                }
                return new int[] {tempMidLeft, tempMidRight};
            }
        }
        return new int[] {-1, -1};
    }
}