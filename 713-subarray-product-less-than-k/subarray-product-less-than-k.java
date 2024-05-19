/**
1. Want to find the number of arrays, but CONTIGUOUS, so we can apply range(j - i) technique to locate all the subarrays

2. So in the slidingwindow while loop, when the condition product is NOT (greater than or equal to k) we update the product, remove slow, outside while loop, we have product which is strictly less than k, we use range(j - i) since it is CONTIGUOUS*/

class Solution {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        if (k <= 1) return 0;
        
        int product = 1;
        int slow = 0, fast = 0, count = 0;
        while (fast < nums.length) {
            product *= nums[fast];
            while (product >= k) {
                product /= nums[slow];
                slow++;
            }
            count += fast - slow + 1;
            fast++;
        }
        return count;
    }
}