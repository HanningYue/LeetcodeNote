/*
We want to return the starting and ending index of the given target number in nums.
1. Binary Search, since the array is sorted, let 左边界为0 右边界为nums.length
    when left < right, 检查中边界与target-number的比较(< , > or ==)
2. 我们想要返还一个range，所以当mid的数字等于target时，我们create一个temporary local variable记录当前mid的index，然后分别向左和向右iterate (一定要在这个区间因为要-1)
3. 可以是当low <= high的condition， 因为array有可能只有一个数字
4. 当< 或者 > target的时候 +1 和 -1 因为我们只要求最后的target_range
*/
class Solution {
    public int[] searchRange(int[] nums, int target) {
        int low = 0, high = nums.length - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (nums[mid] == target) {
                int leftBoundary = mid;
                int rightBoundary = mid;
                while (leftBoundary - 1 >= 0 && nums[leftBoundary - 1] == target) {
                    leftBoundary--;
                }
                while (rightBoundary + 1 < nums.length && nums[rightBoundary + 1] == target) {
                    rightBoundary++;
                }
                return new int[]{leftBoundary, rightBoundary};
            } else if (nums[mid] > target) {
                high = mid - 1;
            } else if (nums[mid] < target) {
                low = mid + 1;
            }
        }
        return new int[]{-1, -1};
    }
}