/**
minHeap or QuickSort
When quick sorting, 
[... kth ...]       Since position is index, we looking for the KTH, add 1 to index when comparing
To the left of kth number, are all the numbers greater than k
To the right of kth number, are all the numbers smaller than k
Use two pointer to find the range and swap helper function to quick sort
*/
class Solution {
    public int findKthLargest(int[] nums, int k) {
        int low = 0, high = nums.length - 1;
        while (low <= high) {
            int mid = partition(nums, low, high);
            if (mid + 1 == k) {
                return nums[mid];
            } else if (mid + 1 < k) {
                low = mid + 1;
            } else if (mid + 1 > k) {
                high = mid - 1;
            }
        }
        return -1;
    }

    private int partition(int[] nums, int low, int high) {
        int pivot = nums[low];
        int left = low + 1;
        int right = high;
        while (left <= right) {
            if (nums[left] < pivot && nums[right] > pivot) {
                swap(nums, left, right);
                left++;
                right--;
            }
            if (nums[left] >= pivot) {
                left++;
            }
            if (nums[right] <= pivot){
                right--;
            }
        }
        swap(nums, low, right);
        return right;
    }

    private void swap(int[] nums, int a, int b) {
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }
}