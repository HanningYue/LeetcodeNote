/**
Divide the given SORTED sequence into two halves [4,5,6,7,0,1,2,3] 
Perform Binary Search, compare the two sorted arrays with nums[mid] with nums[low] and nums[high], ONLY ONE condition is true, 
whether nums[mid] >= nums[low] or nums[mid] <= nums[high]. 
Then find the location of target, if{} else{}*/
class Solution {
	public int search(int[] nums, int target) {
        int low = 0, high = nums.length - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (nums[mid] == target) {
                return mid;
            }

            if (nums[mid] >= nums[low]) {
                if (target >= nums[low] && target < nums[mid]) {
                    high = mid - 1;
                } else {
                    low = mid + 1;
                }
            } else if (nums[mid] <= nums[high]){
                if (target > nums[mid] && target<= nums[high]) {
                    low = mid + 1;
                } else {
                    high = mid - 1;
                }
            }
        }
        return  -1;
    }
}