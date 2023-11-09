/*
Want to return the indices of two indices (added 1) that adds up to a specific sum
Given numbers array non-decreasing order and target, we can use two pointer
    (index)Left pointer to right, Right pointer to left
        If sum is smaller than target, move left pointer to right
        If sum is bigger than target, move right pointer to left.
*/
class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int leftP = 0;
        int rightP = numbers.length - 1;
        while (leftP < rightP) {
            int sum = numbers[leftP] + numbers[rightP];
            if (sum < target) {
                leftP++;
            } else if (sum > target) {
                rightP--;
            } else {
                return new int[] {leftP + 1, rightP + 1};
            }
        }
        return new int[]{-1, -1};
    }
}